package com.champsoft.healthcaremilestone.modules.billing.api.dto;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingStatus;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.DueDate;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.InvoiceItem;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;

import java.time.LocalDate;

public record BillingResponse(
        String id,
        LocalDate dueDate,
        PaymentMethod paymentMethod,
        BillingStatus status,
        String description,
        double amount
) {
}
