package com.example.prueba.shared.exceptions;

public class SinRegistrosException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public SinRegistrosException(String mensaje) {
		super(mensaje);
	}
}
