package com.adidas.backend.publicservice.controller;

import com.adidas.backend.publicservice.dto.SubscribeDto;
import com.adidas.backend.publicservice.exception.InvalidDataException;
import com.adidas.backend.publicservice.service.PrioritySale.PrioritySaleService;
import com.adidas.backend.publicservice.validator.EmailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/subsription")
public class SubscriptionRestController {

    @Autowired
    private PrioritySaleService prioritySaleService;

    @RequestMapping(method = RequestMethod.POST, value = "subscribe")
    public ResponseEntity<?> subscribeToPrioritaryList(@RequestBody SubscribeDto subscribe) throws InvalidDataException {
        if (subscribe == null || subscribe.email == null) {
            log.error("Email not specified");
            throw new InvalidDataException("Email can not be null");
        }

        if (!EmailValidator.isValidEmail(subscribe.email)) {
            log.error("Invalid email format");
            throw new InvalidDataException("Provided email is not valid");
        }

        this.prioritySaleService.subscibe(subscribe.email);

        return ResponseEntity.ok().build();
    }
}
