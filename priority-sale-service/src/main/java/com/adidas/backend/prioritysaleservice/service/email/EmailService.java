package com.adidas.backend.prioritysaleservice.service.email;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email", url = "${feign.email.url}", path = "/email")
public interface EmailService {

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    void sendEmail(@RequestParam(value = "emailAddress") String email);
}
