package com.adidas.backend.prioritysaleservice.task;

import com.adidas.backend.prioritysaleservice.exception.CanNotDequeueUserException;
import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import com.adidas.backend.prioritysaleservice.service.email.EmailService;
import com.adidas.backend.prioritysaleservice.service.email.dto.SendMailDto;
import com.adidas.backend.prioritysaleservice.service.prioritaryqueue.PrioritaryQueueService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SendMailTaskTests {

    @Mock
    private PrioritaryQueueService prioritaryQueueServiceMock;

    @Mock
    private EmailService emailServiceMock;

    @InjectMocks
    private SendMailTask sendMailTask;

    @Test
    public void sendMailToFirstUserInList_shouldCallEmailServiceSendMailWithProperUserIfQueueIsNotEmpty() throws CanNotDequeueUserException {
        // arrange
        String email = "example@domain.com";
        AdiClubMemberInfoDto firstMember = new AdiClubMemberInfoDto(email, 0, Instant.now());

        when(prioritaryQueueServiceMock.dequeueFirst()).thenReturn(firstMember);

        // act
        sendMailTask.sendMailToFirstUserInList();

        // assert
        verify(emailServiceMock, times(1))
                .sendEmail(argThat(sendMailDto -> sendMailDto.getEmail().equals(email)));
    }

    @Test
    public void sendMailToFirstUserInList_shouldNotCallEmailServiceSendMailWithProperUserIfQueueIsEmpty() throws CanNotDequeueUserException {
        // arrange
        when(prioritaryQueueServiceMock.dequeueFirst()).thenThrow(new CanNotDequeueUserException("Can not dequeue user from an empty list"));

        // act
        sendMailTask.sendMailToFirstUserInList();

        // assert
        verify(emailServiceMock, never())
                .sendEmail(any(SendMailDto.class));
    }
}
