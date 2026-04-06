package com.champsoft.healthcaremilestone.modules.billing.domain.model;

import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidInvoiceItemException;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;

import java.util.List;

public class Billing {

    private BillingId id;
    private PatientRef patientId;
    private AppointmentRef appointmentId;
    private Money totalAmount;
    private PaymentMethod paymentMethod;
    private BillingStatus status;
    private List<InvoiceItem> invoices;

    public Billing(BillingId id, PatientRef patientId, Money totalAmount, AppointmentRef appointmentId, PaymentMethod paymentMethod, BillingStatus status, List<InvoiceItem> invoices) {
        this.id = id;
        this.patientId = patientId;
        this.totalAmount = totalAmount;
        this.appointmentId = appointmentId;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.invoices = invoices;
    }


    public BillingId id() {
        return id;
    }

    public void setId(BillingId id) {
        this.id = id;
    }

    //+
    public Money totalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Money totalAmount) { this.totalAmount = totalAmount; }

    public PaymentMethod paymentMethod() {return paymentMethod;}

    public void setPaymentMethod(PaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}

    public BillingStatus status() {return status;}

    public void setStatus(BillingStatus status) {this.status = status;}

    public List<InvoiceItem> invoices() {return invoices;}

    public void setInvoices(List<InvoiceItem> invoices) {

        this.invoices = invoices;
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

//    public PatientRef patientId() {
//        return patientId;
//    }
//
//    public void setPatientId(PatientRef patientId) {
//        this.patientId = patientId;
//    }
//
//    public AppointmentRef appointmentId() {
//        return appointmentId;
//    }
//
//    public void setAppointmentId(AppointmentRef appointmentId) {this.appointmentId = appointmentId;}


}
