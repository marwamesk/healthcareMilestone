package com.champsoft.healthcaremilestone.modules.appointment.api.mapper;

import com.champsoft.healthcaremilestone.modules.appointment.api.dto.AppointmentResponse;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.Appointment;

public class AppointmentRepresentationAssembler {

    public static AppointmentResponse toResponse(Appointment a) {
        AppointmentResponse r = new AppointmentResponse();

        r.id = a.id().value();
        r.doctorId = a.doctorId().value();
        r.patientId = a.patientId().value();
        r.billingId=a.getBillingRef().value();
        r.status = a.status().name();
        r.time = a.time().value();

        return r;
    }
}