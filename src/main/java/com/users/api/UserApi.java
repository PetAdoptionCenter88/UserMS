package com.users.api;


import com.users.document.Role;
import com.users.document.User;
import com.users.dto.UserDTO;
import com.users.exception.UserMSException;
import com.users.service.UserService;

import com.users.utility.validators.validator.groups.LoginGroup;
import com.users.utility.validators.validator.groups.PasswordUpdateGroup;
import com.users.utility.validators.validator.groups.RegisterGroup;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
public class UserApi {
    @Autowired
    Environment environment;
    @Autowired
    UserService userService;

    @PostMapping("/consumers/register")
    public ResponseEntity<String> registerUser(@Validated(RegisterGroup.class) @RequestBody UserDTO user) throws UserMSException {
      user.setRole(Role.CONSUMER);
      return  new ResponseEntity<>(environment.getProperty("UserMSApi.User.Registration.Success")+ " "+userService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/admins/register-staff")
    public ResponseEntity<String> addShelterWorker(@Validated(RegisterGroup.class) @RequestBody UserDTO user) throws UserMSException {
        user.setRole(Role.SHELTER_STAFF);
        return  new ResponseEntity<>(environment.getProperty("UserMSApi.Shelter.Worker.Registration.Success")+" "+userService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@Validated(LoginGroup.class) @RequestBody UserDTO user) throws UserMSException {
        return  new ResponseEntity<>(userService.login(user),HttpStatus.OK);
    }
    @PutMapping("/password/update")
    public ResponseEntity<String> updatePassword(@Validated(PasswordUpdateGroup.class) @RequestBody UserDTO user) throws UserMSException {
        userService.updatePassword(user);
        return  new ResponseEntity<>(environment.getProperty("UserMSApi.Password.Update.Success"),HttpStatus.OK);
    }

}
