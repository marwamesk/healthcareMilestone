package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

import java.time.Duration;
import java.time.LocalDateTime;

public record TimeSlot(LocalDateTime start, LocalDateTime end) {

    public TimeSlot {
        if (start == null || end == null) {
            throw new IllegalArgumentException("TimeSlot cannot be null");
        }
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start must be before end");
        }
        if (Duration.between(start, end).toHours() > 3) {
            throw new IllegalArgumentException("Max 3 hours allowed");
        }

    }

}