package kr.co.agramar.demo.api.controller;

import kr.co.agramar.demo.api.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/sample")
public class DemoController {

	private final DemoService demoService;

}
