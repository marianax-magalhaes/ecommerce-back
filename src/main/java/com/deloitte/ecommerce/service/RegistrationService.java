package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.domain.Customer;
import com.deloitte.ecommerce.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public Customer saveUser(Customer user){
       return repo.save(user);
    }

    public Customer fetchUserByEmail(String email){
        return repo.findByEmail(email);
    }
}
