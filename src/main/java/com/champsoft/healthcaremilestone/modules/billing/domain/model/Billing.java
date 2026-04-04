package com.champsoft.healthcaremilestone.modules.billing.domain.model;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;

import java.util.List;

public class Billing {

    BillingId id;
    PatientRef patientId;
    AppointmentRef appointmentId;
    Money totalAmount;
    PaymentMethod paymentMethod;
    BillingStatus status;
    List<InvoiceItem> invoices;

}
