package com.champsoft.healthcaremilestone.modules.doctor.domain.exception;

public class DoctorLicenseExpiredException extends RuntimeException {
    public DoctorLicenseExpiredException(String message) {
        super(message);
    }
}