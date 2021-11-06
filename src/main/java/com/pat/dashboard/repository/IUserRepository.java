package com.pat.dashboard.repository;

import com.pat.dashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
