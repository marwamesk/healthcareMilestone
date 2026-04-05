package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdatePatientRequest(
        @NotBlank String id,
        @NotBlank String healthCardNum,
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull LocalDate expiryDate

) {
}
