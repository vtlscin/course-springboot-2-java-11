package com.example.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.course.services.exceptions.DataBaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // intercepta exceçoes para que esse objeto possa tratar
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //metodo com capacidade de inteceptar a requisacao que causou a excecao
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request)
	{
		String error = "Resource not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err =  new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request)
	{
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err =  new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
