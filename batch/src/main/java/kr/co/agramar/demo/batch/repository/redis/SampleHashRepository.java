package kr.co.agramar.demo.batch.repository.redis;

import kr.co.agramar.demo.batch.entity.redis.SampleHash;
import org.springframework.data.repository.CrudRepository;

public interface SampleHashRepository extends CrudRepository<SampleHash, Long> {
}
