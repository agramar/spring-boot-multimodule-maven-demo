package kr.co.agramar.demo.api.model.dto.response;

import kr.co.agramar.demo.core.entity.jpa.DemoEntity;
import kr.co.agramar.demo.api.model.vo.DemoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoDTO {

	private Long id;
	private String description;
	private LocalDateTime regDt;

	public static DemoDTO of(DemoEntity demoEntity) {
		if (demoEntity == null)
			return null;
		return DemoDTO.builder()
			.id(demoEntity.getId())
			.description(demoEntity.getDescription())
			.regDt(demoEntity.getRegDate())
			.build();
	}

	public static DemoDTO of(DemoVO demoVO) {
		if (demoVO == null)
			return null;
		return DemoDTO.builder()
			.id(demoVO.getId())
			.description(demoVO.getDescription())
			.regDt(demoVO.getRegDate())
			.build();
	}
}
