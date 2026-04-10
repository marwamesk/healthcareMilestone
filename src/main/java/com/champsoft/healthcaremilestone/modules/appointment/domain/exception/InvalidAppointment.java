package com.champsoft.healthcaremilestone.modules.appointment.domain.exception;

public class InvalidAppointment extends RuntimeException {
    public InvalidAppointment(String message) {
        super(message);
    }
}
