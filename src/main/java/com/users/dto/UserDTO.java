package com.users.dto;


import com.users.document.Role;
import com.users.document.User;
import com.users.utility.validators.validator.ValidEmailOrPhone;
import com.users.utility.validators.validator.ValidPassword;
import com.users.utility.validators.validator.ValidPreviousPassword;
import com.users.utility.validators.validator.groups.LoginGroup;
import com.users.utility.validators.validator.groups.PasswordUpdateGroup;
import com.users.utility.validators.validator.groups.RegisterGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ValidEmailOrPhone(message = "{email.or.phone}" , groups = {PasswordUpdateGroup.class,LoginGroup.class})
@ValidPreviousPassword(message = "{previous.password.not.equal}" ,groups = {PasswordUpdateGroup.class})
public class UserDTO {
    @NotNull(message = "{firstname.notnull}" , groups = {RegisterGroup.class})
    @Pattern(regexp = "[A-Z][a-z]*" , message = "{firstname.invalid}")
    private String firstName;
    @NotNull(message = "{lastname.notnull}" , groups = {RegisterGroup.class})
    @Pattern(regexp = "[A-Z][a-z]*" , message = "{lastname.invalid}")
    private String lastName;
    @NotNull(message = "{email.notnull}" ,groups = {RegisterGroup.class})
    @Email(message = "{email.invalid}" , groups = {RegisterGroup.class, LoginGroup.class , PasswordUpdateGroup.class})
    private String email;
    @NotNull(message = "{phone.notnull}" ,groups = {RegisterGroup.class})
    @Max(value=9999999999L ,message = "{phone.invalid}" , groups = {RegisterGroup.class, LoginGroup.class , PasswordUpdateGroup.class})
    @Min(value=1000000000L  ,message = "{phone.invalid}",  groups = {RegisterGroup.class, LoginGroup.class , PasswordUpdateGroup.class})
    private Long phone;
    @NotNull(message = "{password.notnull}" ,groups = {RegisterGroup.class, LoginGroup.class , PasswordUpdateGroup.class})
    @ValidPassword(message = "{password.invalid}", groups = {RegisterGroup.class, LoginGroup.class , PasswordUpdateGroup.class})
    private String password;
    @Null(message = "{role.null}" ,groups = {RegisterGroup.class})
    @NotNull(message = "{role.notnull}" ,groups = {LoginGroup.class , PasswordUpdateGroup.class})
    private Role role;
    @NotNull(message = "{address.notnull}" ,groups = {RegisterGroup.class})
    @Null(message = "{address.null}" ,groups = {LoginGroup.class , PasswordUpdateGroup.class})
    @Valid
    private AddressDTO addressDTO;
    @Null(message = "{newpassword.null}" ,groups = {RegisterGroup.class, LoginGroup.class})
    @NotNull(message = "{newpassword.notnull}" ,groups = { PasswordUpdateGroup.class})
    @ValidPassword(message = "{newpassword.invalid}", groups = {PasswordUpdateGroup.class})
    private String newPassword;
}
