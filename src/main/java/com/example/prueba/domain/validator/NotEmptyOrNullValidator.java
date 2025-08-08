package com.example.prueba.domain.validator;

import java.util.List;
import java.util.Objects;

import com.example.prueba.domain.exceptions.ValidacionException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyOrNullValidator implements ConstraintValidator<NotEmptyOrNull, Object>{
   private String campo;

    @Override
    public void initialize(NotEmptyOrNull constraintAnnotation) {
        this.campo = constraintAnnotation.campo(); // Permite obtener el nombre del campo
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            throw new ValidacionException("El campo '" + campo + "' no puede ser nulo.");
        }

        if (value instanceof String texto && texto.isBlank()) {
            throw new ValidacionException("El campo '" + campo + "' no puede estar vacío.");
        }

        if (value instanceof List<?> lista && lista.isEmpty()) {
            throw new ValidacionException("El campo '" + campo + "' no puede ser una lista vacía.");
        }

        return true;
    }

}
