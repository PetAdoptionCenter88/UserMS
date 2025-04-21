package com.users.utility.validators.validator;

import com.users.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailOrPhoneValidator implements ConstraintValidator<ValidEmailOrPhone, UserDTO> {

    @Override
    public void initialize(ValidEmailOrPhone constraintAnnotation) {
        // Initialization logic (if needed)
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        if (userDTO == null) {
            return false;
        }
        // Check if either email or phone is not null or empty
        boolean isEmailValid = userDTO.getEmail() != null && !userDTO.getEmail().isEmpty();
        boolean isPhoneValid = userDTO.getPhone() != null;
        return (isEmailValid && !isPhoneValid) || (!isEmailValid && isPhoneValid);
    }
}