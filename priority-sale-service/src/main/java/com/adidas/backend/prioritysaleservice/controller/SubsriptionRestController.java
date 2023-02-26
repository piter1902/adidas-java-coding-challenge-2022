package com.adidas.backend.prioritysaleservice.controller;

import com.adidas.backend.prioritysaleservice.entities.PrioritaryQueue;
import com.adidas.backend.prioritysaleservice.service.AdiClub.AdiClubService;
import com.adidas.backend.prioritysaleservice.service.AdiClub.dto.AdiClubMemberInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/subscription")
public class SubsriptionRestController {

    @Autowired
    private AdiClubService adiClubService;

    private static PrioritaryQueue queue = new PrioritaryQueue();

    @RequestMapping(method = RequestMethod.POST, value = "subscribe")
    public ResponseEntity<?> subscribeToPriorityList(@RequestParam(value = "emailAddress") String email) {

        log.debug("Received email " + email);

        AdiClubMemberInfoDto memberInfo = this.adiClubService.getMemberInformationForEmail(email);

        log.debug("Member info: " +memberInfo.points + " (points); " + memberInfo.registrationDate + " (subscription date)");

        queue.addUserToQueue(memberInfo);

        log.debug("LIST: \n" + queue.getQueue() + "---------");

        return ResponseEntity.ok().build();
    }

}
