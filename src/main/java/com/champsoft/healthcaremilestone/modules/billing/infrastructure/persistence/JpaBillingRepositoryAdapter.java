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

    private final SpringDataBillingRepository repo;

    public JpaBillingRepositoryAdapter(SpringDataBillingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Billing save(Billing billing) {
        BillingJpaEntity entity = BillingMapper.toEntity(billing);
        return BillingMapper.toDomain(repo.save(entity));
    }

    @Override
    public Optional<Billing> findById(BillingId id) {
        return repo.findById(id.value())
                .map(BillingMapper::toDomain);
    }

    @Override
    public List<Billing> findAll() {
        return repo.findAll()
                .stream()
                .map(BillingMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(BillingId id) {
        repo.deleteById(id.value());
    }
}