package com.adidas.backend.prioritysaleservice.controller;

import com.adidas.backend.prioritysaleservice.dto.SubscribeDto;
import com.adidas.backend.prioritysaleservice.exception.CanNotQueueUserException;
import com.adidas.backend.prioritysaleservice.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionRestController {

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * Subscribes user to prioritary access list
     * @param subscribe user information
     * @return OK if user is subscribed to prioritary access list
     */
    @RequestMapping(method = RequestMethod.POST, value = "subscribe")
    public ResponseEntity<?> subscribeToPrioritaryList(@Valid @NotNull @RequestBody SubscribeDto subscribe) throws CanNotQueueUserException {
        subscriptionService.subscribeToPrioritaryList(subscribe);
        return ResponseEntity.ok().build();
    }

}
