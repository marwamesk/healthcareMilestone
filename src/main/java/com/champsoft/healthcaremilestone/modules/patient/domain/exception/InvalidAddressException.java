package com.champsoft.healthcaremilestone.modules.patient.domain.exception;

public class InvalidAddressException extends RuntimeException {
    public InvalidAddressException(String message) {
        super(message);
    }
}
