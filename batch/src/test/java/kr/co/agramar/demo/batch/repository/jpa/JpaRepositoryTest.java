package kr.co.agramar.demo.batch.repository.jpa;

import kr.co.agramar.demo.core.repository.jpa.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("JPA Repository 테스트")
class JpaRepositoryTest {

	@Autowired
	MovieRepository movieRepository;

	@Test
	@DisplayName("Repository 동작 테스트")
	void test() {
		movieRepository.findAll();
	}
}
