package com.deloitte.ecommerce.controller;

import com.deloitte.ecommerce.domain.User;
import com.deloitte.ecommerce.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/api/registeruser")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();

//        tbm verificar se o email ja nao existe na base
        if(tempEmail !=null && !"".equals(tempEmail)){
            User userobj = service.fetchUserByEmail(tempEmail);
            if(userobj !=null){
                throw new Exception (("Esse e-mail já está cadastrado!"));
            }
        }

        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
}
