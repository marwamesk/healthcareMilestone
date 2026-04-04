package com.champsoft.healthcaremilestone.modules.patient.domain.exception;

public class ExpiredHealthInsuranceCardException extends RuntimeException {
    public ExpiredHealthInsuranceCardException(String message) {
        super(message);
    }
}
