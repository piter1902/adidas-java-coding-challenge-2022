package com.adidas.backend.prioritysaleservice.service.subscription;

import com.adidas.backend.prioritysaleservice.dto.SubscribeDto;
import com.adidas.backend.prioritysaleservice.exception.CanNotQueueUserException;
import com.adidas.backend.prioritysaleservice.service.adiclub.AdiClubService;
import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import com.adidas.backend.prioritysaleservice.service.prioritaryqueue.PrioritaryQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubscriptionService {

    @Autowired
    private AdiClubService adiClubService;

    @Autowired
    private PrioritaryQueueService prioritaryQueueService;

    public void subscribeToPrioritaryList(SubscribeDto subscribeDto) throws CanNotQueueUserException {
        String email = subscribeDto.getEmail();

        log.debug("Received email " + email);

        AdiClubMemberInfoDto memberInfo = this.adiClubService.getMemberInformationForEmail(email);

        log.debug("Member info: " + memberInfo.getPoints() + " (points); " + memberInfo.getRegistrationDate() + " (registration date)");

        prioritaryQueueService.addUserToQueue(memberInfo);

        log.debug("LIST: \n" + prioritaryQueueService.getQueue() + "---------");
    }
}
