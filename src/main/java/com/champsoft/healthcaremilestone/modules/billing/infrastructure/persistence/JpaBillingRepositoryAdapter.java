package com.champsoft.healthcaremilestone.modules.billing.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.billing.application.port.out.BillingRepositoryPort;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.*;
import com.champsoft.healthcaremilestone.modules.patient.infrastructure.persistence.SpringDataPatientRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public class JpaBillingRepositoryAdapter implements BillingRepositoryPort {

    private final SpringDataBillingRepository jpa;

    public JpaBillingRepositoryAdapter(SpringDataBillingRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Billing save(Billing billing){
        var e = toEntity(billing);
        jpa.save(e);
        return billing;
    }

    @Override
    public Optional<Billing> findById(BillingId id){
        return jpa.findById(id.value()).map(this::toDomain);
    }


    @Override
    public List<Billing> findAll(){
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(BillingId id) {
        jpa.deleteById(id.value());

    }

    private BillingJpaEntity toEntity(Billing b) {
        var e = new BillingJpaEntity();
        e.id = b.id().toString();
        e.dueDate = b.dueDate().dueDate();
        e.paymentMethod = b.paymentMethod();
        e.status = b.status();
        e.invoice = new BillingInvoiceItemEmbeddable(
                b.invoice().description(),
                b.invoice().getAmountItem()

        );

        return e;
    }

    private Billing toDomain(BillingJpaEntity e){
        var billing = new Billing(BillingId.of(e.id),new InvoiceItem(e.invoice.description,e.invoice.amount),new DueDate(e.dueDate),e.paymentMethod,e.status);
        return billing;
    }

}
