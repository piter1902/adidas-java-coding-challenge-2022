package com.adidas.backend.prioritysaleservice.service.adiclub;

import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "adiClub", url = "${feign.adiClub.url}", path = "/adiclub")
public interface AdiClubService {
    @RequestMapping(method = RequestMethod.GET, value = "")
    AdiClubMemberInfoDto getMemberInformationForEmail(@RequestParam(value = "emailAddress") String email);
}
