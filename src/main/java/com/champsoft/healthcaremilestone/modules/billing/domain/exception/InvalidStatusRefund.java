package com.champsoft.healthcaremilestone.modules.billing.domain.exception;

public class InvalidStatusRefund extends RuntimeException {
    public InvalidStatusRefund(String message) {
        super(message);
    }
}
