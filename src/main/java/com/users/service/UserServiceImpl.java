package com.users.service;

import com.users.document.User;
import com.users.dto.UserDTO;
import com.users.exception.UserMSException;
import com.users.repository.UserRepository;
import com.users.utility.hashing.HashingUtil;
import com.users.utility.objectmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(UserDTO userDTO) throws UserMSException {
        if(userRepository.findByEmailAndRole(userDTO.getEmail(),userDTO.getRole()).isPresent()){
            throw new UserMSException("service.email.already.used");
        }
        if(userRepository.findByPhoneAndRole(userDTO.getPhone(),userDTO.getRole()).isPresent()){
            throw new UserMSException("service.phone.already.used");
        }
        User user=userMapper.toUserEntity(userDTO);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User login(UserDTO userDTO) throws UserMSException {
        User user=null;
        if(userDTO.getPhone()!=null){
         user=userRepository.findByPhoneAndRole(userDTO.getPhone(),userDTO.getRole()).orElseThrow(() -> new UserMSException("service.phoneNumber.notfound"));
        }
        else if(userDTO.getEmail()!=null){
         user=userRepository.findByEmailAndRole(userDTO.getEmail(),userDTO.getRole()).orElseThrow(() -> new UserMSException("service.email.notfound"));
        }
        if(user==null || ! HashingUtil.matchPassword(userDTO.getPassword(),user.getPasswordHash())){
          throw new UserMSException("service.password.not.match");
        }
        return user;
    }

    @Override
    public void updatePassword(UserDTO userDTO) throws UserMSException {
        User user=login(userDTO);
        user.setPasswordHash(HashingUtil.hashPassword(userDTO.getNewPassword()));
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}
