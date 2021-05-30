package kr.co.agramar.demo.batch.repository.jpa;

import kr.co.agramar.demo.core.entity.jpa.MovieEntity;
import kr.co.agramar.demo.core.repository.jpa.MovieRepository;

import java.util.List;

public interface MovieRepositoryImpl extends MovieRepository {
	List<MovieEntity> findAllByTitleContains(String title);
}
