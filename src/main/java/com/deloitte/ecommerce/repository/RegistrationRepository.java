package com.deloitte.ecommerce.repository;

import com.deloitte.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Customer, Long> {
}
