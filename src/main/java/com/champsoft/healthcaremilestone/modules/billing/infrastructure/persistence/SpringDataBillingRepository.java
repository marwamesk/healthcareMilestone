package com.champsoft.healthcaremilestone.modules.billing.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBillingRepository
        extends JpaRepository<BillingJpaEntity, String> {
}