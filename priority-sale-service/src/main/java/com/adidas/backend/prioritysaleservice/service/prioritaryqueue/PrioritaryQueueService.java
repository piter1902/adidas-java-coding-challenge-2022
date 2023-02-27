package com.adidas.backend.prioritysaleservice.service.prioritaryqueue;

import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberComparator;
import com.adidas.backend.prioritysaleservice.exception.CanNotDequeueUserException;
import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PrioritaryQueueService {
    final static int FIRST_ELEMENT_INDEX = 0;

    private List<AdiClubMemberInfoDto> queue;

    public PrioritaryQueueService() {
        this.queue = Collections.synchronizedList(new ArrayList<>());
    }

    public AdiClubMemberInfoDto dequeueFirst() throws CanNotDequeueUserException {
        if (queue.isEmpty()) {
            throw new CanNotDequeueUserException("Can not dequeue user of an empty list");
        }

        AdiClubMemberInfoDto member = queue.get(FIRST_ELEMENT_INDEX);
        queue.remove(FIRST_ELEMENT_INDEX);

        return member;
    }

    public void addUserToQueue(AdiClubMemberInfoDto user) {
        queue.add(user);
        sortList();
    }

    public String getQueue() {
        StringBuilder builder = new StringBuilder();
        this.queue.forEach(member ->
                builder
                        .append(member.getEmail())
                        .append(" : ")
                        .append(member.getPoints())
                        .append(" : ")
                        .append(member.getRegistrationDate())
                        .append("\n"));
        return builder.toString();
    }


    // Private Method for sorting queue
    private void sortList() {
        // Sort Criteria: points then registration date
        this.queue.sort(new AdiClubMemberComparator());
    }
}
