package com.champsoft.healthcaremilestone.modules.billing.application.service;

import com.champsoft.healthcaremilestone.modules.billing.application.exception.BillingNotFoundException;
import com.champsoft.healthcaremilestone.modules.billing.application.port.out.BillingRepositoryPort;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillingCrudService {

    private final BillingRepositoryPort repo;

    public BillingCrudService(BillingRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional
    public Billing create(InvoiceItem item1,InvoiceItem item2, DueDate dueDate, PaymentMethod paymentMethod){
            List<InvoiceItem> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            var bill = new Billing(BillingId.newId(),item1,item2,dueDate,paymentMethod,BillingStatus.PENDING);
            return repo.save(bill);
    }

    @Transactional(readOnly = true)
    public Billing getById(String id){
        return repo.findById(BillingId.of(id)).orElseThrow(()-> new BillingNotFoundException("Billing not found: "+ id ));
    }

    @Transactional(readOnly = true)
    public List<Billing> list(){
        return repo.findAll();
    }


    @Transactional
        public Billing updateFirstItem(String id,InvoiceItem newItem){
        if (newItem == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        var billing = getById(id);

        billing.updateFirstItem(newItem);

        return repo.save(billing);
    }

    @Transactional
    public Billing updateSecondItem(String id,InvoiceItem newItem){
        if (newItem == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        var billing = getById(id);

        billing.updateSecondItem(newItem);

        return repo.save(billing);
    }

    @Transactional
    public Billing refunded(String id){
        var bill = getById(id);
        bill.refunded();
        return repo.save(bill);
    }

    @Transactional
    public Billing paid(String id){
        var bill = getById(id);
        bill.paid();
        return repo.save(bill);
    }

    @Transactional
    public void delete(String id){
        getById(id);
        repo.deleteById(BillingId.of(id));
    }


}
