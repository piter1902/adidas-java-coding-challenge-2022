package com.adidas.backend.prioritysaleservice.controller;

import com.adidas.backend.prioritysaleservice.dto.SubscribeDto;
import com.adidas.backend.prioritysaleservice.service.subscription.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = SubscriptionRestController.class)
public class SubscriptionRestControllerTests {

    @MockBean
    private SubscriptionService subscriptionService;

    @InjectMocks
    private SubscriptionRestController subscriptionRestController;

    @Test
    public void subscribeToPrioritaryList_shouldReturnOkResponse() {
        // arrange
        String email = "example@domain.com";

        SubscribeDto subscribeDto = new SubscribeDto(email);

        // act
        ResponseEntity<?> response = subscriptionRestController.subscribeToPrioritaryList(subscribeDto);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void subscribeToPrioritaryList_shouldCallSubscriptionServiceSubscribeToPrioritaryListWithProperEmail() {
        // arrange
        String email = "example@domain.com";

        SubscribeDto subscribeDto = new SubscribeDto(email);

        // act
        subscriptionRestController.subscribeToPrioritaryList(subscribeDto);

        // assert
        verify(subscriptionService).subscribeToPrioritaryList(subscribeDto);
    }
}
