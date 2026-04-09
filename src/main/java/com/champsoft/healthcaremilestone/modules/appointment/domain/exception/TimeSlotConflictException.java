package com.champsoft.healthcaremilestone.modules.appointment.domain.exception;

public class TimeSlotConflictException extends RuntimeException {
    public TimeSlotConflictException(String message) {
        super(message);
    }
}
