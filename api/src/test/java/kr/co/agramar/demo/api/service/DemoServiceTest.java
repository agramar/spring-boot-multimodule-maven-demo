package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.model.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	public void testSaveDemoRepository() {
		demoService.saveDemoRepository();
	}

	@Test
	public void testSelectDemoList() {
		List<DemoVO> demoVOList = demoService.selectDemoList();
		log.info("demoVOList : {}", demoVOList);
		Assertions.assertNotNull(demoVOList);
	}
}
