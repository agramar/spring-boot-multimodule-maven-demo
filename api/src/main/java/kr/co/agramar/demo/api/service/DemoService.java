package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.mapper.DemoMapper;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import kr.co.agramar.demo.api.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {

	private final DemoMapper demoMapper;
	private final DemoRepository demoRepository;

	public void saveDemoRepository(DemoEntity demoEntity) {
		demoRepository.save(demoEntity);
	}

	public List<DemoVO> selectDemoList() {
		return demoMapper.selectDemoList();
	}
}
