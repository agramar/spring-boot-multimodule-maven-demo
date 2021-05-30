package kr.co.agramar.demo.batch.repository.redis;

import kr.co.agramar.demo.batch.entity.redis.SampleHash;
import kr.co.agramar.demo.core.entity.redis.DemoHash;
import kr.co.agramar.demo.core.repository.redis.DemoHashRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataRedisTest
@DisplayName("레디스 Repository 테스트")
class RedisRepositoryTest {

	@Autowired
	DemoHashRepository demoHashRepository;

	@Autowired
	SampleHashRepository sampleHashRepository;

	@Test
	@DisplayName("DemoHashRepository 동작 테스트")
	void testDemoHashRepository() throws Exception {
		DemoHash expectedDemoHash = DemoHash.builder()
			.id(1L)
			.desc("DESC")
			.build();
		demoHashRepository.save(expectedDemoHash);

		DemoHash actualDemoHash = demoHashRepository.findById(expectedDemoHash.getId()).orElseThrow(Exception::new);

		assertEquals(expectedDemoHash, actualDemoHash);
	}

	@Test
	@DisplayName("SampleHashRepository 동작 테스트")
	void testSampleHashRepository() throws Exception {
		SampleHash sampleHash = SampleHash.builder()
			.id(1L)
			.content("CONTENT")
			.build();
		sampleHashRepository.save(sampleHash);

		SampleHash actualSampleHash = sampleHashRepository.findById(sampleHash.getId()).orElseThrow(Exception::new);

		assertEquals(sampleHash, actualSampleHash);
	}
}
