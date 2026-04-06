package com.champsoft.healthcaremilestone.modules.billing.domain.exception;

public class InvalidInvoiceItemException extends RuntimeException {
    public InvalidInvoiceItemException(String message) {
        super(message);
    }
}
