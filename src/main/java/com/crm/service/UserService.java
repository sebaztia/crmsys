package com.crm.service;

import com.crm.model.User;
import com.crm.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto userRegistrationDto);

    List<User> findUsers();

    User updateRoles(long id, String makeAdmin);
}
