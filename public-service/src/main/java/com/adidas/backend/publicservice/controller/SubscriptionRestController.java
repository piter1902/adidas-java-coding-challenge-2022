package com.adidas.backend.publicservice.controller;

import com.adidas.backend.publicservice.dto.SubscribeDto;
import com.adidas.backend.publicservice.service.prioritysale.PrioritySaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionRestController {

    @Autowired
    private PrioritySaleService prioritySaleService;

    @RequestMapping(method = RequestMethod.POST, value = "subscribe")
    public ResponseEntity<?> subscribeToPrioritaryList(@Valid @RequestBody SubscribeDto subscribe) {
        this.prioritySaleService.subscribe(subscribe);

        return ResponseEntity.ok().build();
    }
}
