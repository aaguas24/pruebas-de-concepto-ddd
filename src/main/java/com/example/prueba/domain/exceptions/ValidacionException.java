package com.example.prueba.domain.exceptions;

public class ValidacionException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidacionException(String mensaje) {
	        super(mensaje);
	    }
}
