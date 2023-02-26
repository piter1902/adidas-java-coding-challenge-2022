package com.adidas.backend.prioritysaleservice.entities;

import com.adidas.backend.prioritysaleservice.exception.CanNotUnqueueUserException;
import com.adidas.backend.prioritysaleservice.service.adiClub.dto.AdiClubMemberInfoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrioritaryQueue {

    final static int FIRST_ELEMENT_INDEX = 0;

    private List<AdiClubMemberInfoDto> queue;

    public PrioritaryQueue() {
        this.queue = Collections.synchronizedList(new ArrayList<>());
    }

    public AdiClubMemberInfoDto unqueueFirst() throws CanNotUnqueueUserException {
        if (queue.isEmpty()) {
            throw new CanNotUnqueueUserException("Can not unqueue user of an empty list");
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
        this.queue.forEach(member -> builder.append(member.email + " : " + member.points + " : " + member.registrationDate + "\n"));
        return builder.toString();
    }


    private void sortList() {
        // Sort Criteria: points then registration date
        this.queue.sort(new AdiClubMemberComparator());
    }
}
