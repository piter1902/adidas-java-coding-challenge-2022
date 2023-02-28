package com.adidas.backend.prioritysaleservice.controller;

import com.adidas.backend.prioritysaleservice.dto.SubscribeDto;
import com.adidas.backend.prioritysaleservice.exception.CanNotQueueUserException;
import com.adidas.backend.prioritysaleservice.service.subscription.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SubscriptionRestControllerTests {
    @Mock
    private SubscriptionService subscriptionService;

    @InjectMocks
    private SubscriptionRestController subscriptionRestController;

    @Test
    public void subscribeToPrioritaryList_shouldReturnOkResponse() throws CanNotQueueUserException {
        // arrange
        String email = "example@domain.com";

        SubscribeDto subscribeDto = new SubscribeDto(email);

        // act
        ResponseEntity<?> response = subscriptionRestController.subscribeToPrioritaryList(subscribeDto);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void subscribeToPrioritaryList_shouldCallSubscriptionServiceSubscribeToPrioritaryListWithProperEmail() throws CanNotQueueUserException {
        // arrange
        String email = "example@domain.com";

        SubscribeDto subscribeDto = new SubscribeDto(email);

        // act
        subscriptionRestController.subscribeToPrioritaryList(subscribeDto);

        // assert
        verify(subscriptionService).subscribeToPrioritaryList(subscribeDto);
    }
}
