package com.champsoft.healthcaremilestone.modules.billing.domain.model;

public record AppointmentRef(String appointmentId){
    public AppointmentRef {
        if(appointmentId==null) throw new IllegalArgumentException("appointmentId is required");
        appointmentId=appointmentId.trim();
        if(appointmentId.isEmpty()) throw new IllegalArgumentException("appointmentId is required");
    }
}

