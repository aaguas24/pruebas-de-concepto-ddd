package com.example.prueba.interfaces.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.prueba.shared.exceptions.SinRegistrosException;
import com.example.prueba.shared.exceptions.ValidacionException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(ValidacionException ex) {
        Map<String, String> errores = new HashMap<>();
        errores.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errores);
    }

    @ExceptionHandler(SinRegistrosException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(SinRegistrosException ex) {
        Map<String, String> errores = new HashMap<>();
        errores.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errores);
    }
}
