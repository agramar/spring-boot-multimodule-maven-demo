package kr.co.agramar.demo.core.repository.jpa;

import kr.co.agramar.demo.core.entity.jpa.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
}
