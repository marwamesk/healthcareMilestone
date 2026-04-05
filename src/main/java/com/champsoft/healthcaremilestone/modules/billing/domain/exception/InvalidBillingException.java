package com.champsoft.healthcaremilestone.modules.billing.domain.exception;

public class InvalidBillingException extends RuntimeException {
    public InvalidBillingException(String message) {
        super(message);
    }
}
