package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.ACL;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.BillingPort;
import com.champsoft.healthcaremilestone.modules.billing.application.service.BillingCrudService;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.DueDate;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.PaymentMethod;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BillingAdapter implements BillingPort {

    private final BillingCrudService billingService;

    public BillingAdapter(BillingCrudService billingService) {
        this.billingService = billingService;
    }

    @Override
    public void createBill(String appointmentId, String patientId) {
        // prepare raw arguments for BillingCrudService
        String description = "Billing for appointment " + appointmentId;
        double amount = 100.0;  // or calculate dynamically
        DueDate dueDate = new DueDate(LocalDate.now().plusDays(7));
        PaymentMethod method = PaymentMethod.CREDIT_CARD;

        // call the service with expected argument list
        billingService.create(description, amount, dueDate, method);
    }
}