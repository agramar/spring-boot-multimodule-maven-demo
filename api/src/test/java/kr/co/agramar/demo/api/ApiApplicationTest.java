package kr.co.agramar.demo.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("API Application 테스트")
class ApiApplicationTest {

    @Test
	@DisplayName("API Application ContextLoad 정상 동작 확인")
    void contextLoads() {
    	assertTrue(true);
    }
}
