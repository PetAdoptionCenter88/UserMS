package com.users.utility.validators.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(8 > s.length() || s.length()>15 ) return false;
        if(! s.matches(".*[0-9].*"))  return false;
        if(! s.matches(".*[A-Z].*"))  return false;
        if(! s.matches(".*[a-z].*"))  return false;
        if(! s.matches(".*[!@#$%^&*].*"))  return false;
        return true;
    }
}
