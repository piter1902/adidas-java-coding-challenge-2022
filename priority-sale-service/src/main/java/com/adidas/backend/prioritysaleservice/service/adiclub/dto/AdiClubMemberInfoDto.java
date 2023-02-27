package com.adidas.backend.prioritysaleservice.service.adiclub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdiClubMemberInfoDto {
    String email;
    Integer points;
    Instant registrationDate;
}
