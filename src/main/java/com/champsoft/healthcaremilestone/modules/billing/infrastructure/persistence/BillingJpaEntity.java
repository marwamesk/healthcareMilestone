package com.champsoft.healthcaremilestone.modules.billing.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingStatus;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.DueDate;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.InvoiceItem;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="billing")
public class BillingJpaEntity {

    @Id
    public String id;

    @Column(nullable = false)
    public LocalDate dueDate;

    @Column(nullable = false)
    public PaymentMethod paymentMethod;

    @Embedded
    public BillingInvoiceItemEmbeddable invoice;

    @Column(nullable = false)
    public BillingStatus status;


}
