package com.champsoft.healthcaremilestone.modules.billing.application.exception;

public class BillingNotFoundException extends RuntimeException {
    public BillingNotFoundException(String message) {
        super(message);
    }
}
