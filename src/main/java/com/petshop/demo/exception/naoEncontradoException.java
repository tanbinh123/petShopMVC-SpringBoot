package com.petshop.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class naoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public naoEncontradoException(String message) {
		super(message);
	}
	
	public naoEncontradoException(String message, Throwable t) {
		super(message, t);
	}
}
