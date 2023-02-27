package com.adidas.backend.emailservice.service.email;

import com.adidas.backend.emailservice.dto.SendMailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    public void sendEmail(SendMailDto sendMailDto) {
        String email = sendMailDto.getEmail();
        log.info("Sending mail to " + email);
    }
}
