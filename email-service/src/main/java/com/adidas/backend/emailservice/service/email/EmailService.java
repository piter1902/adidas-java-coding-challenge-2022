package com.adidas.backend.emailservice.service.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    public void sendEmail(String email) {
        log.info("Sending mail to " + email);
    }
}
