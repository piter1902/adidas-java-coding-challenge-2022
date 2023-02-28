package com.adidas.backend.prioritysaleservice.service.adiclub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import com.adidas.backend.prioritysaleservice.entity.MemberInformation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdiClubMemberInfoDto {
    String email;
    Integer points;
    Instant registrationDate;

    public MemberInformation toMemberInformation() {
        return MemberInformation
                .builder()
                .email(email)
                .points(points)
                .registrationDate(registrationDate)
                .build();
    }
}
