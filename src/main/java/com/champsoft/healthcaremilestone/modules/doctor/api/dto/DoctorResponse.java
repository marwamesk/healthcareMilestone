package com.champsoft.healthcaremilestone.modules.doctor.api.dto;

import java.util.UUID;

public record DoctorResponse(
        UUID id,
        String firstName,
        String lastName,
        String specialty,
        String status
) {}