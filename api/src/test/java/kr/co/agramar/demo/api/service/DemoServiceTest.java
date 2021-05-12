package kr.co.agramar.demo.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	public void testRunDemo() {
		demoService.runDemo();
	}
}
