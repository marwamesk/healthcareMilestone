package com.champsoft.healthcaremilestone.modules.appointment.domain.model;


import java.util.UUID;

public record AppointmentId(UUID value) {
    public AppointmentId {
        if (value == null) throw new IllegalArgumentException("AppointmentId cannot be null");
    }
}