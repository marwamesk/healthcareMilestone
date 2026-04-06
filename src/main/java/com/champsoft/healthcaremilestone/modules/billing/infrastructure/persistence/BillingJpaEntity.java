package com.champsoft.healthcaremilestone.modules.billing.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="billing")
public class BillingJpaEntity {

    @Id
    public String id;
}
