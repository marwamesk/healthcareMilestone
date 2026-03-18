package com.champsoft.healthcaremilestone.modules.patient.application.exception;

public class DuplicatePatientException extends RuntimeException {
    public DuplicatePatientException(String message) {
        super(message);
    }
}
