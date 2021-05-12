package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.mapper.DemoMapper;
import kr.co.agramar.demo.api.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {

	private final DemoMapper demoMapper;
	private final DemoRepository demoRepository;

	public void runDemo() {
		demoRepository.save(DemoEntity.builder()
			.description("description")
			.build());
	}
}
