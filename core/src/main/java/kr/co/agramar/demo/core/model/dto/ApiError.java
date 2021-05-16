package kr.co.agramar.demo.core.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
	private Integer status;
	private String message;
	private String code;
}
