package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

import java.time.*;

public record TimeSlot(LocalDateTime start, LocalDateTime end) {

    public TimeSlot {

        if (start == null || end == null) {
            throw new IllegalArgumentException("TimeSlot cannot be null");
        }

        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("Start must be before end");
        }

        if (Duration.between(start, end).toHours() > 3) {
            throw new IllegalArgumentException("Max duration is 3 hours");
        }

        if (start.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot book in the past");
        }

        if (start.isAfter(LocalDateTime.now().plusYears(1))) {
            throw new IllegalArgumentException("Cannot book more than 1 year ahead");
        }

        if (start.toLocalTime().isBefore(LocalTime.of(5, 0)) ||
                end.toLocalTime().isAfter(LocalTime.of(22, 0))) {
            throw new IllegalArgumentException("Outside working hours (5AM–10PM)");
        }

    }
}