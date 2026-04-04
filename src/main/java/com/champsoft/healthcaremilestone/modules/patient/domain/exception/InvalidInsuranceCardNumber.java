package com.champsoft.healthcaremilestone.modules.patient.domain.exception;

public class InvalidInsuranceCardNumber extends RuntimeException{
    public InvalidInsuranceCardNumber(String message) {
        super(message);
    }
}
