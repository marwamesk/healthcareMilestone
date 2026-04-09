package com.champsoft.healthcaremilestone.modules.appointment.api.dto;

import java.time.LocalDateTime;

public class UpdateAppointmentRequest {
    public LocalDateTime time;
    public String status; // "SCHEDULED", "COMPLETED", "CANCELLED"
}