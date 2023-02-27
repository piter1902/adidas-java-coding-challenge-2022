package com.adidas.backend.emailservice.controller;

import com.adidas.backend.emailservice.dto.SendMailDto;
import com.adidas.backend.emailservice.service.email.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = EmailRestController.class)
public class EmailRestControllerTests {

    @MockBean
    private EmailService emailServiceMock;

    @InjectMocks
    private EmailRestController emailRestController;

    @Test
    public void sendEmail_shouldReturnOkResponse() {
        // arrange
        String email = "example@domain.com";
        SendMailDto sendMailDto = new SendMailDto(email);

        // act
        ResponseEntity<?> response = emailRestController.sendEmail(sendMailDto);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void sendEmail_shouldCallEmailServiceSendMail() {
        // arrange
        String email = "example@domain.com";
        SendMailDto sendMailDto = new SendMailDto(email);

        // act
        emailRestController.sendEmail(sendMailDto);

        // assert
        verify(emailServiceMock, times(1)).sendEmail(sendMailDto);
    }
}
