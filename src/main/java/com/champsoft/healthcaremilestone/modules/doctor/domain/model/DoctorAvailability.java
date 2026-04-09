package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DoctorAvailability {

    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

    public DoctorAvailability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;

        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("Invalid availability time range");
        }
    }

    public boolean matches(java.time.LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().equals(day)
                && !dateTime.toLocalTime().isBefore(startTime)
                && !dateTime.toLocalTime().isAfter(endTime);
    }
}