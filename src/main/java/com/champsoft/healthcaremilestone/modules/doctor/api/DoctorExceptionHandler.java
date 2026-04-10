package com.champsoft.healthcaremilestone.modules.doctor.api;

import com.champsoft.healthcaremilestone.modules.doctor.domain.exception.DoctorLicenseExpiredException;
import com.champsoft.healthcaremilestone.modules.doctor.domain.exception.DoctorNotFoundException;
import com.champsoft.healthcaremilestone.modules.doctor.domain.exception.DuplicateDoctorException;
import com.champsoft.healthcaremilestone.modules.patient.application.exception.DuplicatePatientException;
import com.champsoft.healthcaremilestone.modules.patient.domain.exception.*;
import com.champsoft.healthcaremilestone.shared.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class DoctorExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(DoctorNotFoundException ex, HttpServletRequest req){
        return build(HttpStatus.NOT_FOUND,ex,req);
    }

    @ExceptionHandler(DuplicatePatientException.class)
    public ResponseEntity<ApiErrorResponse> conflict(DuplicateDoctorException ex, HttpServletRequest req){
        return build(HttpStatus.CONFLICT,ex,req);
    }

    private ResponseEntity<ApiErrorResponse> build(HttpStatus status, Exception ex, HttpServletRequest req){
        var body = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler({
            DoctorLicenseExpiredException.class,
    })
    public ResponseEntity<ApiErrorResponse> badRequest(RuntimeException ex, HttpServletRequest req){
        return build(HttpStatus.BAD_REQUEST,ex,req);
    }

    //+
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse>
    badRequest(org.springframework.web.bind.MethodArgumentNotValidException ex,
               HttpServletRequest req){

        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(err -> err.getField()+" "+ err.getDefaultMessage()).orElse("Failed");
        return build(HttpStatus.BAD_REQUEST,new IllegalArgumentException(message),req);

    }
}
