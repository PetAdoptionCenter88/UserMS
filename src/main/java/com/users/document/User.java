package com.users.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String passwordHash; // For security, always store hashed
    private Role role;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
