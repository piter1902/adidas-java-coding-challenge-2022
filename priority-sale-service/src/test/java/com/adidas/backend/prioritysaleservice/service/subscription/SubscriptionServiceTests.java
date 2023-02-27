package com.adidas.backend.prioritysaleservice.service.subscription;

import com.adidas.backend.prioritysaleservice.dto.SubscribeDto;
import com.adidas.backend.prioritysaleservice.exception.CanNotQueueUserException;
import com.adidas.backend.prioritysaleservice.service.adiclub.AdiClubService;
import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import com.adidas.backend.prioritysaleservice.service.prioritaryqueue.PrioritaryQueueService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTests {

    @Mock
    private PrioritaryQueueService prioritaryQueueServiceMock;

    @Mock
    private AdiClubService adiClubServiceMock;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Test
    public void subscribeToPrioritaryList_shouldCallPrioritaryQueueServiceAddUserToQueueWithProperEmail() throws CanNotQueueUserException {
        // arrange
        String email = "example@domain.com";
        SubscribeDto subscribeDto = new SubscribeDto(email);

        AdiClubMemberInfoDto expectedMemberInfo = new AdiClubMemberInfoDto(email, 0, Instant.now());
        when(adiClubServiceMock.getMemberInformationForEmail(email)).thenReturn(expectedMemberInfo);

        // act
        subscriptionService.subscribeToPrioritaryList(subscribeDto);

        // assert
        verify(prioritaryQueueServiceMock, times(1)).addUserToQueue(expectedMemberInfo);
    }

}
