package com.users.repository;

import com.users.document.Role;
import com.users.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByPhoneAndRole(Long phone, Role role);
    Optional<User> findByEmailAndRole(String email, Role role);
   }
