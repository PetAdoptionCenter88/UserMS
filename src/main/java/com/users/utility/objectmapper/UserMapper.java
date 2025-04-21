package com.users.utility.objectmapper;

import com.users.document.Address;
import com.users.document.User;
import com.users.dto.AddressDTO;
import com.users.dto.UserDTO;
import com.users.utility.hashing.HashingUtil;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(source = "addressDTO", target = "address", qualifiedByName = "toAddressEntity")
    @Mapping(source = "password", target = "passwordHash", qualifiedByName = "hashPassword")
    User toUserEntity(UserDTO dto);

    @Named("toAddressEntity")
    Address toAddressEntity(AddressDTO dto);

    @Named("hashPassword")
    static String hashPassword(String password){
        return HashingUtil.hashPassword(password);
    }
}
