package com.champsoft.healthcaremilestone.modules.appointment.api.mapper;


import com.champsoft.healthcaremilestone.modules.appointment.api.dto.*;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;

public class AppointmentApiMapper {

    public static AppointmentResponse toResponse(Appointment a) {
        return new AppointmentResponse(
                a.getId().value(),
                a.getPatientId(),
                a.getDoctorId(),
                a.getTimeSlot().getStart(),
                a.getTimeSlot().getEnd(),
                a.getStatus().name()
        );
    }
}