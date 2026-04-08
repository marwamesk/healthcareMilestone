package com.champsoft.healthcaremilestone.modules.billing.domain.model;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Billing {

    private final BillingId id;
    private final DueDate dueDate;
    @Setter
    private PaymentMethod paymentMethod;
    @Setter
    private BillingStatus status;
    private List<InvoiceItem> invoices;

    public Billing(BillingId id,InvoiceItem item1, InvoiceItem item2, DueDate dueDate, PaymentMethod paymentMethod, BillingStatus status) {
        this.id = id;
        this.dueDate=dueDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.invoices = new ArrayList<>();
        this.status=status;

        this.invoices.add(item1);

        if(item2 !=null){
            this.invoices.add(item2);
        }
    }


    public BillingId id() {
        return id;
    }

    public DueDate dueDate() {
        return dueDate;
    }

    public Double totalAmount(List<InvoiceItem> items) {
        double total =0;
        for(InvoiceItem item : items ){
            total += item.getAmountItem();
        }
        return total;
    }


    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }

    public BillingStatus status() {
        return status;
    }

    public List<InvoiceItem> invoices() {
        return invoices;
    }

    public void removeInvoice(String description,double amount) {
        invoices.removeIf(item->
                item.description().equals(description)&&
                item.getAmountItem() == amount
                );
    }

    public void updateFirstItem(InvoiceItem item) {
        invoices.set(0, item);
    }

    public void updateSecondItem(InvoiceItem item) {
        if (invoices.size() < 2) {
            throw new IllegalStateException("Second item does not exist");
        }
        invoices.set(1, item);
    }


    public void paid(){
        this.status=BillingStatus.PAID;
    }

    public void cancelled(){
        this.status=BillingStatus.CANCELLED;
    }

    public void pending(){
        this.status=BillingStatus.PENDING;
    }

    public void refunded(){
        if(this.status==BillingStatus.REFUNDED)throw new RuntimeException("Billing already refunded");
        this.status=BillingStatus.REFUNDED;
    }


}
