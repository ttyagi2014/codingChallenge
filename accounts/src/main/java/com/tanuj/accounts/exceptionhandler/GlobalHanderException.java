package com.tanuj.accounts.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHanderException {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> getExceptionResponse(){
		return ResponseEntity.accepted()
					  .body("Something wrong")
					  .status(HttpStatus.INTERNAL_SERVER_ERROR)
					  .build();
	}

}
