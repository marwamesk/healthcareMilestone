package com.champsoft.healthcaremilestone.modules.appointment.application.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException() {
        super("Doctor not found");
    }
}