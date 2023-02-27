package com.adidas.backend.publicservice.service.prioritysale;

import com.adidas.backend.publicservice.dto.SubscribeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "prioritySale", url = "${feign.prioritySaleClient.url}", path = "/subscription")
public interface PrioritySaleService {
    @RequestMapping(method = RequestMethod.POST, value = "/subscribe")
    void subscribe(@RequestBody SubscribeDto subscribe);
}
