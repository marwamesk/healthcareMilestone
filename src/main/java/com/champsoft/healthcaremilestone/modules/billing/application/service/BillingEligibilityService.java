package com.champsoft.healthcaremilestone.modules.billing.application.service;

import com.champsoft.healthcaremilestone.modules.billing.application.port.out.BillingRepositoryPort;
import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidStatusRefund;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.Billing;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingEligibilityService {

    private final BillingRepositoryPort repo;

    public BillingEligibilityService(@Qualifier("jpaBillingRepositoryAdapter")BillingRepositoryPort repo){
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public boolean isEligibleForRefund(String billingId){
        var v= repo.findById(BillingId.of(billingId)).orElseThrow(()-> new InvalidStatusRefund("Billing cannot be refunded"));
       return  v.isEligibleForRefund();
    }

}
