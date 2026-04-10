package com.champsoft.healthcaremilestone.modules.billing.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingStatus;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "billing")
public class BillingJpaEntity {

    @Id
    private String id;   // IMPORTANT: STRING ONLY (NOT BillingId)

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private BillingStatus status;

    private String description;

    private double amount;
}