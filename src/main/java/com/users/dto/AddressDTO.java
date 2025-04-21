package com.users.dto;


import com.users.utility.validators.validator.groups.RegisterGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    @NotBlank(message = "{user.address.street.notblank}" , groups = RegisterGroup.class)
    private String street;
    @NotBlank(message = "{user.address.city.notblank}" ,groups = RegisterGroup.class)
    private String city;
    @NotBlank(message = "{user.address.state.notblank}", groups = RegisterGroup.class)
    private String state;
    @NotBlank(message = "{user.address.zipcode.notblank}", groups = RegisterGroup.class)
    private String zipCode;
    @NotBlank(message = "{user.address.country.notblank}", groups = RegisterGroup.class)
    private String country;
}