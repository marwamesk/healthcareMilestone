package com.champsoft.healthcaremilestone.modules.doctor.api;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.*;
import com.champsoft.healthcaremilestone.modules.doctor.api.mapper.DoctorDtoMapper;
import com.champsoft.healthcaremilestone.modules.doctor.application.service.DoctorCrudService;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorCrudService service;

    public DoctorController(DoctorCrudService service) {
        this.service = service;
    }

    //  CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateDoctorRequest request) {
        Doctor doctor = DoctorDtoMapper.toDomain(request);
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(service.create(doctor)));
    }

    //  GET ALL
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<DoctorResponse> list = service.getAll()
                .stream()
                .map(DoctorDtoMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(service.getById(id)));
    }

    //  UPDATE BASIC INFO (DDD behavior)
    @PutMapping("/{id}/info")
    public ResponseEntity<?> updateInfo(@PathVariable UUID id,
                                        @RequestBody @Valid UpdateDoctorRequest request) {
        Doctor updated = service.updateInfo(id, request.firstName(), request.lastName(), request.specialty());
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(updated));
    }

    //  UPDATE LICENSE (important domain behavior)
    @PutMapping("/{id}/license")
    public ResponseEntity<?> updateLicense(@PathVariable UUID id,
                                           @RequestBody UpdateLicenseRequest request) {
        Doctor updated = service.updateLicense(id, request.getLicenseExpiryDate());
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(updated));
    }

    //  ACTIVATE DOCTOR
    @PutMapping("/{id}/activate")
    public ResponseEntity<?> activate(@PathVariable UUID id) {
        Doctor updated = service.activate(id);
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(updated));
    }

    //  DEACTIVATE DOCTOR
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivate(@PathVariable UUID id) {
        Doctor updated = service.deactivate(id);
        return ResponseEntity.ok(DoctorDtoMapper.toResponse(updated));
    }

    //  DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Doctor deleted");
    }
}