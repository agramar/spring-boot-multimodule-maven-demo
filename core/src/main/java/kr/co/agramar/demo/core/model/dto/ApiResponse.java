package kr.co.agramar.demo.core.model.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private Integer status = 200;
	private String message = "success";
	private T data;

	public ApiResponse(T data) {
		this.data = data;
	}
}
