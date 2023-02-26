package com.adidas.backend.publicservice.service.PrioritySale;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "prioritySale", url = "${feign.prioritySaleClient.url}", path = "/subscription")
public interface PrioritySaleService {
    @RequestMapping(method = RequestMethod.POST, value = "/subscribe")
    void subscibe(@RequestParam(value = "emailAddress") String email);
}
