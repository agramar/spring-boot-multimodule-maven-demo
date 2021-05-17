package kr.co.agramar.demo.api.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoRequestDto {
	@NotEmpty(message = "id 값은 비어 있을수 없습니다.")
	private String id;
}
