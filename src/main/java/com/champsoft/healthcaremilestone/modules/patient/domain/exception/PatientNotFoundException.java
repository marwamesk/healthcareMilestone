package com.champsoft.healthcaremilestone.modules.patient.domain.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
