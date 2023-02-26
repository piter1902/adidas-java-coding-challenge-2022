package com.adidas.backend.emailservice.controller;

import com.adidas.backend.emailservice.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailRestController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(method = RequestMethod.POST, value = "send")
    public void sendEmail(@RequestParam(name = "emailAddress") String email) {
        this.emailService.sendEmail(email);
    }
}
