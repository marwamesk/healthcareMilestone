package com.champsoft.healthcaremilestone.modules.patient.api;

import com.champsoft.healthcaremilestone.modules.patient.api.dto.CreatePatientRequest;
import com.champsoft.healthcaremilestone.modules.patient.api.mapper.PatientApiMapper;
import com.champsoft.healthcaremilestone.modules.patient.application.service.PatientCrudService;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Address;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Health_insuranceCard;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientCrudService service;

    public PatientController(PatientCrudService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreatePatientRequest req){
        Health_insuranceCard card= new Health_insuranceCard(req.healthCardNum(),req.expiryDate());
        Address address = new Address(req.streetNumber(),req.streetName(),req.city(),req.postalCode(),req.Country());
        var v = service.create(req.firstName(),req.lastName(), req.phoneNumber(),req.email(),req.dateOfBirth(),card,address, PatientStatus.STABLE);
        return ResponseEntity.ok(PatientApiMapper.toResponse(v));
    }

}
