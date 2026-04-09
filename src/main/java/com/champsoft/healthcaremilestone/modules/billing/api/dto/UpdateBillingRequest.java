package com.champsoft.healthcaremilestone.modules.billing.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateBillingRequest(
        @NotBlank String description,
        Double amount
) {
}
