package com.champsoft.healthcaremilestone.modules.appointment.api.dto;

import java.time.LocalDateTime;

public class AppointmentResponse {
    public String id;
    public String doctorId;
    public String patientId;
    public String status;
    public LocalDateTime time;

}