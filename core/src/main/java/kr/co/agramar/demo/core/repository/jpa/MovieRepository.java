package kr.co.agramar.demo.core.repository.jpa;

import kr.co.agramar.demo.core.entity.jpa.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
