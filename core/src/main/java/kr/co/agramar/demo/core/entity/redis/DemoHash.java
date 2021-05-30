package kr.co.agramar.demo.core.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("DEMO")
public class DemoHash {
	@Id
	private Long id;
	private String desc;
}
