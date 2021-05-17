package kr.co.agramar.demo.api.service;

import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.mapper.DemoMapper;
import kr.co.agramar.demo.api.model.dto.response.DemoDTO;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import kr.co.agramar.demo.api.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackOn = Throwable.class)
@Service
public class DemoService {

	private final DemoMapper demoMapper;
	private final DemoRepository demoRepository;

	private final ModelMapper modelMapper;

	public void saveDemo(DemoEntity demoEntity) {
		demoRepository.save(demoEntity);
	}

	public List<DemoDTO> selectDemoList() {
		List<DemoVO> demoVOList = demoMapper.selectDemoList();
		return modelMapper.map(demoVOList, new TypeToken<List<DemoDTO>>() {}.getType());
	}

	public List<DemoVO> saveAndSelectList(DemoEntity demoEntity) {
		log.info("demoEntity : {}", demoEntity);
		demoRepository.save(demoEntity);
		List<DemoVO> demoVOList = demoMapper.selectDemoList();
		log.info("demoVOList : {}", demoVOList);
		return demoVOList;
	}
}
