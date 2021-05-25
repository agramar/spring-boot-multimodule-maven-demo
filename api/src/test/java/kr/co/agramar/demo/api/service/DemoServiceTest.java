package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@ConditionalOnProperty(value = "graphql.servlet.enabled", havingValue = "true", matchIfMissing = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@DisplayName("데모 서비스 테스트")
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	@DisplayName("데모 서비스 JPA Repository 작동 테스트")
	void testSaveDemoRepository() {
		demoService.saveDemo(DemoEntity.builder()
			.description("????????????")
			.build());
	}

	@Test
	@DisplayName("데모 서비스 MyBatis Mapper 작동 테스트")
	void testSelectDemoList() {
		List<DemoDTO> demoList = demoService.selectDemoList();
		log.info("demoList : {}", demoList);
		Assertions.assertNotNull(demoList);
	}

	@Test
	@DisplayName("데모 서비스 트랜잭션 작동 테스트")
	void testTransaction() {

		List<DemoDTO> demoList = demoService.selectDemoList();

		List<DemoVO> demoVOList2 = demoService.saveAndSelectList(DemoEntity.builder()
			.description("😂")
			.build());

		Assertions.assertEquals(demoList.size() + 1, demoVOList2.size());
	}

	@Test
	@DisplayName("데모 서비스 Redis Cache 테스트")
	void testCache() throws InterruptedException {
		final List<Long> demoIds = List.of(1L, 2L, 3L, 100L);
		for (Long demoId : demoIds) {
			DemoDTO nonCachedDemo = demoService.findVerySlowQueryDemoDTOById(demoId);
			DemoDTO cachedDemo = demoService.findVerySlowQueryDemoDTOById(demoId);
			Assertions.assertEquals(nonCachedDemo, cachedDemo);
		}
	}
}
