package com.champsoft.healthcaremilestone.modules.billing.application.port.out;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.Billing;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingId;

import java.util.List;
import java.util.Optional;

public interface BillingRepositoryPort {

    Billing save(Billing bill);
    Optional<Billing> findById(BillingId id);
    boolean existById(BillingId id);
    List<Billing> findAll();
    void deleteById(BillingId id);
}
