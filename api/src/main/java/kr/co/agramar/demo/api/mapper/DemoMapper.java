package kr.co.agramar.demo.api.mapper;

import kr.co.agramar.demo.api.model.vo.DemoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {
	List<DemoVO> selectDemoList();
}
