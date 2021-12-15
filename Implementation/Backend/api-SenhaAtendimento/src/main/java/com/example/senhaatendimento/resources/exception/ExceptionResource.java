package com.example.senhaatendimento.resources.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.senhaatendimento.services.expcetion.ExceptionService;

@ControllerAdvice
public class ExceptionResource {
	
	@ExceptionHandler(ExceptionService.class)
	public ResponseEntity<ExceptionDefault> exceptionDefault(ExceptionService e, HttpServletRequest request){
		ExceptionDefault err = new ExceptionDefault();
		err.setTimestamp(LocalDateTime.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("FALHA NA REQUISIÇÃO");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
