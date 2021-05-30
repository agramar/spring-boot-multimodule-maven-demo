package kr.co.agramar.demo.batch.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@RedisHash(value = "SAMPLE", timeToLive = 60L)
public class SampleHash {
	@Id
	private Long id;
	private String content;
}
