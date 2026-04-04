package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;

import java.time.LocalDate;

public record CreatePatientRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String phoneNumber,
        @Email String email,
        @Past LocalDate dateOfBirth,
        @NotBlank String healthCardNum,
        @NotBlank LocalDate expiryDate,
        @NotBlank Integer streetNumber,
        @NotBlank String streetName,
        @NotBlank String city,
        @NotBlank String postalCode,
        @NotBlank String Country
) {
}
