package kr.co.agramar.demo.batch.repository.jpa;

import kr.co.agramar.demo.core.entity.jpa.MovieEntity;
import kr.co.agramar.demo.core.repository.jpa.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@DisplayName("JPA Repository 테스트")
class JpaRepositoryTest {

	@Autowired
	MovieRepository movieRepository;

	@Test
	@DisplayName("Repository 동작 테스트")
	void test() {

		List<MovieEntity> movieEntityList = movieRepository.findAll();

		Assertions.assertNotNull(movieEntityList);
	}
}
