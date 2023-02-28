package com.adidas.backend.prioritysaleservice.task;

import com.adidas.backend.prioritysaleservice.exception.CanNotDequeueUserException;
import com.adidas.backend.prioritysaleservice.entity.MemberInformation;
import com.adidas.backend.prioritysaleservice.service.email.EmailService;
import com.adidas.backend.prioritysaleservice.service.email.dto.SendMailDto;
import com.adidas.backend.prioritysaleservice.service.prioritaryqueue.PrioritaryQueueService;
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
            MemberInformation member = prioritaryQueueService.dequeueFirst();
            log.debug("Dequeued user is: " + member.getEmail() + "\n----------\n");

            SendMailDto sendMailDto = SendMailDto
                    .builder()
                    .email(member.getEmail())
                    .build();

            emailService.sendEmail(sendMailDto);
        } catch (CanNotDequeueUserException e) {
            log.debug("There are no users in queue");
        }
    }
}
