package com.adidas.backend.prioritysaleservice.service.email.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class SendMailDto {

    @Email
    @NotNull
    String email;
}
