package com.adidas.backend.prioritysaleservice.task;

import com.adidas.backend.prioritysaleservice.exception.CanNotUnqueueUserException;
import com.adidas.backend.prioritysaleservice.service.adiClub.dto.AdiClubMemberInfoDto;
import com.adidas.backend.prioritysaleservice.service.email.EmailService;
import com.adidas.backend.prioritysaleservice.service.prioritaryQueue.PrioritaryQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendMailTask {

    @Autowired
    private PrioritaryQueueService prioritaryQueueService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "${task.sendmail.cron}")
    public void sendMailToFirstUserInList() {
        try {
            AdiClubMemberInfoDto member = prioritaryQueueService.unqueueFirst();
            log.debug("First user is: " + member.email + "\n----------\n");
            emailService.sendEmail(member.email);
        } catch (CanNotUnqueueUserException e) {
            log.debug("There are no users in queue");
        }
    }
}
