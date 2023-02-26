package com.adidas.backend.prioritysaleservice.entities;

import com.adidas.backend.prioritysaleservice.service.AdiClub.dto.AdiClubMemberInfoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrioritaryQueue {
    private List<AdiClubMemberInfoDto> queue;

    public PrioritaryQueue() {
        this.queue = Collections.synchronizedList(new ArrayList<>());
    }

    public String getFirst() {
        if (queue.isEmpty()){
            return null;
        }

        AdiClubMemberInfoDto user = queue.get(0);

        return user.email;
    }

    public void unqueueFirst() {
        if (queue.isEmpty()){
            throw new IndexOutOfBoundsException("Can not unqueue user of an empty list");
        }

        queue.remove(0);
    }

    public void addUserToQueue(AdiClubMemberInfoDto user) {
        queue.add(user);
        sortList();
    }

    public String getQueue() {
        StringBuilder builder = new StringBuilder();
        this.queue.forEach(member -> {
            builder.append(member.email + " : " + member.points + " : " + member.registrationDate + "\n");
        });
        return builder.toString();
    }


    private void sortList() {
        // Sort Criteria: points then registration date
        this.queue.sort(new AdiClubMemberComparator());
    }
}
