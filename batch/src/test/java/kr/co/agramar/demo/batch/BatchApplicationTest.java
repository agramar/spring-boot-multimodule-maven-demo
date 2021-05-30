package kr.co.agramar.demo.batch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Batch Application 테스트")
class BatchApplicationTest {

    @Test
	@DisplayName("Batch Application ContextLoad 정상 동작 확인")
    void contextLoads() {
    }
}
