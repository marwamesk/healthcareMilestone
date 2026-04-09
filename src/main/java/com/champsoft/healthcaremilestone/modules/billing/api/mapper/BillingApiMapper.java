package com.champsoft.healthcaremilestone.modules.billing.api.mapper;

import com.champsoft.healthcaremilestone.modules.billing.api.dto.BillingResponse;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.Billing;

public class BillingApiMapper {

    public static BillingResponse toResponse(Billing b){
        return new BillingResponse(
                b.id().value(),
                b.dueDate().dueDate(),
                b.paymentMethod(),
                b.status(),
                b.invoice().description(),
                b.invoice().getAmountItem()
        );
    }

}
