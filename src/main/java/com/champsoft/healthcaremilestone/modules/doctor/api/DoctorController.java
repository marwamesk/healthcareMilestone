package com.champsoft.healthcaremilestone.modules.doctor.api;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.CreateDoctorRequest;
import com.champsoft.healthcaremilestone.modules.doctor.api.dto.DoctorResponse;
import com.champsoft.healthcaremilestone.modules.doctor.api.mapper.DoctorApiMapper;
import com.champsoft.healthcaremilestone.modules.doctor.application.service.DoctorCrudService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorCrudService service;

    public DoctorController(DoctorCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> create(
            @Valid @RequestBody CreateDoctorRequest request) {

        var doctor = service.create(
                request.firstName(),
                request.lastName(),
                request.specialty()
        );

        return ResponseEntity
                .status(201)
                .body(DoctorApiMapper.toResponse(doctor));
    }

    @GetMapping
    public List<DoctorResponse> getAll() {
        return service.getAll()
                .stream()
                .map(DoctorApiMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public DoctorResponse getById(@PathVariable UUID id) {
        return DoctorApiMapper.toResponse(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}