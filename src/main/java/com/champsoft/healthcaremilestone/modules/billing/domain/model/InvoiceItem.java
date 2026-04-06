package com.champsoft.healthcaremilestone.modules.billing.domain.model;

import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidInvoiceItemException;

public class InvoiceItem {

    private String description;
    private Money amount;

    public InvoiceItem(String description, Money amount) {
        if(description.isEmpty()) throw new InvalidInvoiceItemException("Description is required");
        if(amount == null) throw new InvalidInvoiceItemException("Amount is required");
        this.description = description;
        this.amount=amount;
    }


    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getAmountItem() {
        return amount;
    }

    public void setAmountItem(Money amount) {
        this.amount = amount;
    }




}
