package com.ajay.tech.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {
	
	private String msg;
	private List<String> details;
	private HttpStatus httpStatus;
	private LocalDateTime timeStamp;

}
