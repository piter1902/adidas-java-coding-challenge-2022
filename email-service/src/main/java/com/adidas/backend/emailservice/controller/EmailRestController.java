package com.adidas.backend.emailservice.controller;

import com.adidas.backend.emailservice.dto.SendMailDto;
import com.adidas.backend.emailservice.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/email")
public class EmailRestController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(method = RequestMethod.POST, value = "send")
    public ResponseEntity<?> sendEmail(@Valid @NotNull @RequestBody SendMailDto sendMailDto) {
        this.emailService.sendEmail(sendMailDto);

        return ResponseEntity.ok().build();
    }
}
