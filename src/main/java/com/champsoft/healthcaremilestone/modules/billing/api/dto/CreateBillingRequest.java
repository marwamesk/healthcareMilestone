package com.champsoft.healthcaremilestone.modules.billing.api.dto;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateBillingRequest(

        @NotBlank String description,
        @NotNull Double amount,
        @NotNull LocalDate dueDate,
        @NotNull PaymentMethod method
) {}