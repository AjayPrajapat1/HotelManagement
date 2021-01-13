package com.ajay.tech.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method Not Supported");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type Not Supported");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path variable is missing");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);

	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Type Mismatch");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);

	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("HTTP Message Not Readable");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method Argument Not Valid");
		ApiErrors apiErrors = new ApiErrors(msg, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(apiErrors);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException ex){
		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Hotel Not Found");
		ApiErrors apiErrors = new ApiErrors(msg, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.badRequest().body(apiErrors);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex){
		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Invalid Id");
		ApiErrors apiErrors = new ApiErrors(msg, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.badRequest().body(apiErrors);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleAll(Exception ex){
		String msg = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method Not Supported");
		details.add(ex.getMessage());
		ApiErrors apiErrors = new ApiErrors(msg, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.badRequest().body(apiErrors);

	}

}
