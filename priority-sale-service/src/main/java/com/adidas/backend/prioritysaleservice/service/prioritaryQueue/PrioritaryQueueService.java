package com.adidas.backend.prioritysaleservice.service.prioritaryQueue;

import com.adidas.backend.prioritysaleservice.entities.PrioritaryQueue;
import com.adidas.backend.prioritysaleservice.exception.CanNotUnqueueUserException;
import com.adidas.backend.prioritysaleservice.service.adiClub.dto.AdiClubMemberInfoDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PrioritaryQueueService {

    private static PrioritaryQueue queue = new PrioritaryQueue();


    public AdiClubMemberInfoDto unqueueFirst() throws CanNotUnqueueUserException {
        return queue.unqueueFirst();
    }

    public void addUserToQueue(AdiClubMemberInfoDto user) {
        queue.addUserToQueue(user);
    }

    public String getQueue() {
        return queue.getQueue();
    }
}
