package com.adidas.backend.prioritysaleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberInformation {

    @Id
    private String id;

    private String email;

    private Integer points;

    private Instant registrationDate;
}