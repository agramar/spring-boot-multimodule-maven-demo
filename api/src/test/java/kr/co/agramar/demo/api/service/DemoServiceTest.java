package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@ConditionalOnProperty(value = "graphql.servlet.enabled", havingValue = "true", matchIfMissing = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	public void testSaveDemoRepository() {
		demoService.saveDemo(DemoEntity.builder()
			.description("????????????")
			.build());
	}

	@Test
	public void testSelectDemoList() {
		List<DemoDTO> demoList = demoService.selectDemoList();
		log.info("demoList : {}", demoList);
		Assertions.assertNotNull(demoList);
	}

	@Test
	public void testTransaction() {

		List<DemoDTO> demoList = demoService.selectDemoList();

		List<DemoVO> demoVOList2 = demoService.saveAndSelectList(DemoEntity.builder()
			.description("😂")
			.build());

		Assertions.assertEquals(demoList.size() + 1, demoVOList2.size());
	}
}
