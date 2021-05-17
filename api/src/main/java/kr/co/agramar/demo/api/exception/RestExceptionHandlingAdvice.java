package kr.co.agramar.demo.api.exception;

import kr.co.agramar.demo.core.model.dto.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandlingAdvice {

	@ExceptionHandler(Throwable.class)
	protected ResponseEntity<ApiError> handleException(Throwable e) {
		log.error(e.getMessage(), e);
		final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		final ApiError apiError = ApiError.builder()
			.status(httpStatus.value())
			.message(e.getMessage())
			.code(httpStatus.name())
			.build();

		return ResponseEntity
			.status(httpStatus)
			.body(apiError);
	}

	@ExceptionHandler(BindException.class)
	protected ResponseEntity<ApiError> handleBindException(BindException e) {
		log.error(e.getMessage());
		final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		final ApiError apiError = ApiError.builder()
			.status(httpStatus.value())
			.message(e.getLocalizedMessage())
			.code(httpStatus.name())
			.build();

		return ResponseEntity
			.status(httpStatus)
			.body(apiError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error(e.getMessage());
		final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		final ApiError apiError = ApiError.builder()
			.status(httpStatus.value())
			.message(e.getMessage())
			.code(httpStatus.name())
			.build();

		return ResponseEntity
			.status(httpStatus)
			.body(apiError);
	}
}
