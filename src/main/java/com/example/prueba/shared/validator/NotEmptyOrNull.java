package com.example.prueba.shared.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = NotEmptyOrNullValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyOrNull {
	String message() default "El campo no puede ser nulo ni vacío";

	String campo() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
