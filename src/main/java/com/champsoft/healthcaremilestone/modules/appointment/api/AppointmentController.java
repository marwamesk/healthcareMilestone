package com.champsoft.healthcaremilestone.modules.appointment.api;



import com.champsoft.healthcaremilestone.modules.appointment.api.dto.*;
import com.champsoft.healthcaremilestone.modules.appointment.api.mapper.*;
import com.champsoft.healthcaremilestone.modules.appointment.application.service.*;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentCrudService service;

    public AppointmentController(AppointmentCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> create(
            @Valid @RequestBody CreateAppointmentRequest request) {

        var appointment = service.create(
                request.patientId(),
                request.doctorId(),
                new TimeSlot(request.startTime(), request.endTime())
        );

        return ResponseEntity.status(201)
                .body(AppointmentApiMapper.toResponse(appointment));
    }

    @GetMapping
    public List<AppointmentResponse> getAll() {
        return service.getAll().stream()
                .map(AppointmentApiMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public AppointmentResponse getById(@PathVariable UUID id) {
        return AppointmentApiMapper.toResponse(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}