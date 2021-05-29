package kr.co.agramar.demo.api.controller;

import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo-sse")
public class DemoSseController {

	private final DemoService demoService;

	@GetMapping("/demo-stream")
	public SseEmitter streamDemoSse() {

		log.info("demo-stream start");

		SseEmitter sseEmitter = new SseEmitter();

		try {
			List<CompletableFuture<DemoDTO>> demoFutureList = new ArrayList<>();
			for (long i = 0; i < 10; i++) {
				demoFutureList.add(demoService.findDemoAsync(i));
			}

			for (CompletableFuture<DemoDTO> demoDTOCompletableFuture : demoFutureList) {
				demoDTOCompletableFuture
					.thenAcceptAsync(demoDTO -> {
						try {
							log.info("send demo-stream");
							if (demoDTO != null) {
								sseEmitter.send(SseEmitter.event()
									.id(String.valueOf(System.currentTimeMillis()))
									.name("MESSAGE")
									.data(demoDTO));
							}
						} catch (IOException e) {
							log.error(e.getMessage());
						}
					});
			}

			CompletableFuture.allOf(demoFutureList.toArray(new CompletableFuture[0]))
				.thenRun(() -> {
					try {
						sseEmitter.send(SseEmitter.event()
							.id(String.valueOf(System.currentTimeMillis()))
							.name("COMPLETE"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					sseEmitter.complete();
					log.info("event stream complete");
				});
		} catch (Exception e) {
			log.error(e.getMessage());
			sseEmitter.completeWithError(e);
		}

		return sseEmitter;
	}
}
