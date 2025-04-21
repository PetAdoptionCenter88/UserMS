package com.users.utility.validators.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailOrPhoneValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailOrPhone {
    String message() default "";  // Default error message
    Class<?>[] groups() default {};            // Default groups for validation
    Class<? extends Payload>[] payload() default {}; // Payload, for additional metadata
}

