package com.champsoft.healthcaremilestone.modules.doctor.domain.exception;

public class DuplicateDoctorException extends RuntimeException {
    public DuplicateDoctorException(String message) {
        super(message);
    }
}
