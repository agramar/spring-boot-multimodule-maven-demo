package kr.co.agramar.demo.api.controller;

import kr.co.agramar.demo.api.model.vo.DemoVO;
import kr.co.agramar.demo.api.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

	private final DemoService demoService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<DemoVO>> getDemoList() {
		log.info("getDemoList");
		return ResponseEntity.ok(demoService.selectDemoList());
	}

}
