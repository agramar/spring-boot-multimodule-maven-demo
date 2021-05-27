package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.mapper.DemoMapper;
import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import kr.co.agramar.demo.api.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackOn = Throwable.class)
@Service
public class DemoService {

	private final DemoMapper demoMapper;
	private final DemoRepository demoRepository;

	public void saveDemo(DemoEntity demoEntity) {
		demoRepository.save(demoEntity);
	}

	public List<DemoDTO> selectDemoList() {
		List<DemoVO> demoVOList = demoMapper.selectDemoList();
		return demoVOList.stream().map(DemoDTO::of).collect(Collectors.toList());
	}

	public List<DemoVO> saveAndSelectList(DemoEntity demoEntity) {
		log.info("demoEntity : {}", demoEntity);
		demoRepository.save(demoEntity);
		List<DemoVO> demoVOList = demoMapper.selectDemoList();
		log.info("demoVOList : {}", demoVOList);
		return demoVOList;
	}

	@Cacheable(cacheNames = "findDemoById", key = "#id", unless="#result == null")
	public DemoDTO findVerySlowQueryDemoDTOById(Long id) throws InterruptedException {
		Thread.sleep(1000);
		return DemoDTO.of(demoRepository.findById(id).orElse(null));
	}

	@Async
	public CompletableFuture<DemoDTO> findDemoAsync(Long id) throws InterruptedException {
		Thread.sleep(new Random().nextInt(10000));
		return CompletableFuture.completedFuture(DemoDTO.of(demoRepository.findById(id).orElse(null)));
	}
}
