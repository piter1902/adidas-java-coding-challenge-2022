package com.adidas.backend.publicservice.controller;

import com.adidas.backend.publicservice.dto.SubscribeDto;
import com.adidas.backend.publicservice.service.prioritysale.PrioritySaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    /**
     * Subscribes user to prioritary access list
     *
     * @param subscribe user information
     * @return OK if user is subscribed to prioritary access list
     */
    @Operation(operationId = "subscribeToPrioritaryList", description = "Subscribes user to prioritary access list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User subscribed to prioritary access list"),
            @ApiResponse(responseCode = "400", description = "Validation error in input data"),
            @ApiResponse(responseCode = "409", description = "Conflict when adding user to prioritary access list")
    })
    @RequestMapping(method = RequestMethod.POST, value = "subscribe")
    public ResponseEntity<?> subscribeToPrioritaryList(@Valid @RequestBody SubscribeDto subscribe) {
        this.prioritySaleService.subscribe(subscribe);

        return ResponseEntity.ok().build();
    }
}
