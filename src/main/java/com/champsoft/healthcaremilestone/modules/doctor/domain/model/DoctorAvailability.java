package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Getter;

/**
 * Represents a recurring availability slot for a doctor.
 */
@Getter
public class DoctorAvailability {

    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public DoctorAvailability(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Checks if the given dateTime falls within this availability slot.
     */
    public boolean matches(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == dayOfWeek &&
                !dateTime.toLocalTime().isBefore(startTime) &&
                !dateTime.toLocalTime().isAfter(endTime);
    }
}