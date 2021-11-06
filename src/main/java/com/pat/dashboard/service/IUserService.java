package com.pat.dashboard.service;

import com.pat.dashboard.model.User;
import com.pat.dashboard.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
    User findByUsername(String username);
}
