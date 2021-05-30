package kr.co.agramar.demo.core.repository.redis;

import kr.co.agramar.demo.core.entity.redis.DemoHash;
import org.springframework.data.repository.CrudRepository;

public interface DemoHashRepository extends CrudRepository<DemoHash, Long> {
}
