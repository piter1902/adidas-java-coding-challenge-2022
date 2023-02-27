package com.adidas.backend.prioritysaleservice.service.adiclub.dto;

import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;

import java.util.Comparator;

public class AdiClubMemberComparator implements Comparator<AdiClubMemberInfoDto> {
    @Override
    public int compare(AdiClubMemberInfoDto o1, AdiClubMemberInfoDto o2) {
        int points = o2.getPoints() - o1.getPoints();
        int registration = 0;

        if (points == 0) {
            registration = o2.getRegistrationDate().compareTo(o1.getRegistrationDate());
        }

        return points + registration;
    }
}
