package com.example.prueba.shared.exceptions;

public class ValidacionException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ValidacionException(String mensaje) {
		super(mensaje);
	}
}
