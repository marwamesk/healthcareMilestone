package com.champsoft.healthcaremilestone.modules.appointment.api.mapper;

import com.champsoft.healthcaremilestone.modules.appointment.api.dto.AppointmentResponse;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.Appointment;

public class AppointmentRepresentationAssembler {

    public static AppointmentResponse toResponse(Appointment appt) {
        AppointmentResponse res = new AppointmentResponse();
        res.id = appt.id().value();
        res.doctorId = appt.doctorIdValue();
        res.patientId = appt.patientIdValue();
        res.status = appt.status().name();
        res.time = appt.timeValue();
        return res;
    }
}