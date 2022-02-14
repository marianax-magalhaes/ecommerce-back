package com.deloitte.ecommerce.repository;

import com.deloitte.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
