package com.hanex.starter.error;

import com.hanex.starter.common.annotation.CustomErrorLog;
import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.error.exception.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	private final MessageSource messageSource;

	@CustomErrorLog
	@ExceptionHandler(Exception400.class)
	public ResponseEntity<?> badRequest(Exception400 e){
		return new ResponseEntity<>(e.body(), e.status());
	}

	@CustomErrorLog
	@ExceptionHandler(Exception401.class)
	public ResponseEntity<?> unAuthorized(Exception401 e){
		return new ResponseEntity<>(e.body(), e.status());
	}

	@CustomErrorLog
	@ExceptionHandler(Exception403.class)
	public ResponseEntity<?> forbidden(Exception403 e){
		return new ResponseEntity<>(e.body(), e.status());
	}

	@CustomErrorLog
	@ExceptionHandler(Exception404.class)
	public ResponseEntity<?> notFound(Exception404 e){
		return new ResponseEntity<>(e.body(), e.status());
	}

	@CustomErrorLog
	@ExceptionHandler(Exception500.class)
	public ResponseEntity<?> serverError(Exception500 e){
		return new ResponseEntity<>(e.body(), e.status());
	}

	@CustomErrorLog
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> unknownServerError(Exception e){
		ApiResponseDto<String> apiResponseDto = new ApiResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR, "unknownServerError", e.getMessage());
		return new ResponseEntity<>(apiResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	public String getMessage(String code){
		return getMessage(code,null);
	}


	public String getMessage(String code,Object[] args){
		return messageSource.getMessage(code ,args, LocaleContextHolder.getLocale());
	}

}