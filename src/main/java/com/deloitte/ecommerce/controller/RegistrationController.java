package com.deloitte.ecommerce.controller;

import com.deloitte.ecommerce.domain.Customer;
import com.deloitte.ecommerce.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/registeruser")
    public Customer registerUser(@RequestBody Customer user){
        String tempEmail = user.getFirstName();

//        tbm verificar se o email ja nao existe na base
        if(tempEmail !=null && !"".equals(tempEmail)){

        }

        Customer userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
}
