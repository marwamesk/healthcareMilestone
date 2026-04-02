package com.champsoft.healthcaremilestone.modules.appointment.api.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateAppointmentRequest(
        @NotNull UUID patientId,
        @NotNull UUID doctorId,
        @NotNull LocalDateTime startTime,
        @NotNull LocalDateTime endTime
) {}