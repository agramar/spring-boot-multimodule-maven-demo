package kr.co.agramar.demo.core.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse<T> {
	private Integer status;
	private String message;
	private T data;
}
