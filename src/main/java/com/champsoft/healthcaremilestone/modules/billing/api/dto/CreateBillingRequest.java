package com.champsoft.healthcaremilestone.modules.billing.api.dto;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingStatus;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateBillingRequest(
        @NotBlank String description,
        double amount,
        LocalDate dueDate,
        PaymentMethod method
) {
}
