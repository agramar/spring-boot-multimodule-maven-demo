package kr.co.agramar.demo.api.model.dto.response;

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
}
