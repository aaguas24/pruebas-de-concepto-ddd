package com.example.prueba.interfaces.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.prueba.shared.exceptions.SinRegistrosException;
import com.example.prueba.shared.exceptions.ValidacionException;

/**
 * Global Exception Handler para traducir excepciones de dominio a respuestas
 * HTTP.
 * Maneja excepciones específicas y proporciona respuestas JSON estructuradas.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja ValidacionException (errores de validación de negocio).
     * Retorna 400 Bad Request.
     */
    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<Object> handleValidacionException(ValidacionException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    /**
     * Maneja SinRegistrosException (recursos no encontrados).
     * Retorna 404 Not Found.
     */
    @ExceptionHandler(SinRegistrosException.class)
    public ResponseEntity<Object> handleSinRegistrosException(SinRegistrosException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NO_CONTENT.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
    }

    /**
     * Maneja excepciones genéricas no manejadas.
     * Retorna 500 Internal Server Error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "Ha ocurrido un error interno. Por favor intente nuevamente más tarde.");
        body.put("path", request.getDescription(false).replace("uri=", ""));

        // En producción, no exponer el stack trace por seguridad
        // body.put("details", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
