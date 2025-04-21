package com.users.utility.hashing;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashingUtil {

    // Hash a raw password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Compare a raw password to a hashed one
    public static boolean matchPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null) return false;
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
