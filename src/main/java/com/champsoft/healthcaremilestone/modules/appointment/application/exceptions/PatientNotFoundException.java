package com.champsoft.healthcaremilestone.modules.appointment.application.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException() {
        super("Patient not found");
    }
}