package com.champsoft.healthcaremilestone.modules.doctor.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateDoctorRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String specialty
) {}