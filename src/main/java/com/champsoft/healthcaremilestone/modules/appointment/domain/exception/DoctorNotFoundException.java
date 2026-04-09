package com.champsoft.healthcaremilestone.modules.appointment.domain.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
