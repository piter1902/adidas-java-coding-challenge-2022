package com.adidas.backend.prioritysaleservice.service.email;

import com.adidas.backend.prioritysaleservice.service.email.dto.SendMailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email", url = "${feign.email.url}", path = "/email")
public interface EmailService {

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    void sendEmail(@RequestBody SendMailDto sendMailDto);
}
