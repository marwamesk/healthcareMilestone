package com.champsoft.healthcaremilestone.modules.billing.application.service;

import com.champsoft.healthcaremilestone.modules.billing.application.port.out.BillingRepositoryPort;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.Billing;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingEligibilityService {

    private final BillingRepositoryPort repo;

    public BillingEligibilityService(BillingRepositoryPort repo) {
        this.repo = repo;
    }
//
//    @Transactional(readOnly = true)
//    public boolean isEligible(String billingId){
//        return repo.findById(BillingId.of(billingId).map(b->b.))
//    }
}
