package com.users.service;


import com.users.document.User;
import com.users.dto.UserDTO;
import com.users.exception.UserMSException;

public interface UserService {
public String register(UserDTO user) throws UserMSException;
public User login(UserDTO user) throws UserMSException ;
public void updatePassword(UserDTO user) throws UserMSException ;

}
