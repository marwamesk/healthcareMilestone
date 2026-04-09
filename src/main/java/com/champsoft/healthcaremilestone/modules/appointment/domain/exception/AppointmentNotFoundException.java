package com.champsoft.healthcaremilestone.modules.appointment.domain.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}