package kr.co.agramar.demo.api.controller;

import kr.co.agramar.demo.api.model.dto.request.DemoRequestDto;
import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.service.DemoService;
import kr.co.agramar.demo.core.model.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

	private final DemoService demoService;

	@GetMapping(value = "/test")
	public ResponseEntity<ApiResponse<String>> test(@Valid DemoRequestDto demoRequestDto) {
		log.info("demoRequestDto : {}", demoRequestDto);
		return ResponseEntity.ok(new ApiResponse<>(demoRequestDto.getId()));
	}

	@GetMapping(value = "/demo")
	public ResponseEntity<ApiResponse<List<DemoDTO>>> getDemoList() {
		return ResponseEntity.ok(new ApiResponse<>(demoService.selectDemoList()));
	}

}
