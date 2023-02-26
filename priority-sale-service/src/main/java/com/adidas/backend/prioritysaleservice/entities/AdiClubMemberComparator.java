package com.adidas.backend.prioritysaleservice.entities;

import com.adidas.backend.prioritysaleservice.service.AdiClub.dto.AdiClubMemberInfoDto;

import java.util.Comparator;

public class AdiClubMemberComparator implements Comparator<AdiClubMemberInfoDto> {
    @Override
    public int compare(AdiClubMemberInfoDto o1, AdiClubMemberInfoDto o2) {
        int points = o2.points - o1.points;
        int registration = 0;

        if (points == 0) {
            registration = o2.registrationDate.compareTo(o1.registrationDate);
        }

        return points + registration;
    }
}
