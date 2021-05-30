package kr.co.agramar.demo.cloudconfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("CloudConfigApplication 테스트")
class CloudConfigApplicationTest {

	@Test
	@DisplayName("CloudConfigApplication ContextLoad 정상 동작 확인")
	void contextLoads() {
		assertTrue(true);
	}

}
