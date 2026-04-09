package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;

public interface BillingPort {
    void createBill(String appointmentId, String patientId);
}