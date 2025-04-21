package com.users.utility.validators.validator;

import com.users.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PreviousPasswordValidator implements ConstraintValidator<ValidPreviousPassword, UserDTO> {

    @Override
    public void initialize(ValidPreviousPassword constraintAnnotation) {
        // Initialization logic (if needed)
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        if (userDTO == null || userDTO.getPassword() == null || userDTO.getNewPassword() == null) {
            return false;
        }
        return !userDTO.getPassword().equalsIgnoreCase(userDTO.getNewPassword());
    }
}