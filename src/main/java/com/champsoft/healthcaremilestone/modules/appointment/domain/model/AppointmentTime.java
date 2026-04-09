package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

import java.time.LocalDateTime;

public record AppointmentTime(LocalDateTime value) {
    public AppointmentTime {
        if (value.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Time cannot be in the past");
        }
    }
}