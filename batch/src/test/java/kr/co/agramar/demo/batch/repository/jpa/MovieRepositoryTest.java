package kr.co.agramar.demo.batch.repository.jpa;

import kr.co.agramar.demo.core.entity.jpa.MovieEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@DisplayName("Movie Repository 테스트")
class MovieRepositoryTest {

	@Autowired
	MovieRepositoryImpl movieRepository;

	@Test
	@DisplayName("제목으로 영화 찾기 테스트")
	void testFindAllByTitleContains() {

		List<MovieEntity> movieEntityList = movieRepository.findAllByTitleContains("?");

		Assertions.assertNotNull(movieEntityList);
	}
}
