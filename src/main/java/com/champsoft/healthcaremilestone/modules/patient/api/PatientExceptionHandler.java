package com.champsoft.healthcaremilestone.modules.patient.api;

import com.champsoft.healthcaremilestone.modules.patient.domain.exception.PatientNotFoundException;
import com.champsoft.healthcaremilestone.shared.config.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = PatientController.class)
public class PatientExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(PatientNotFoundException ex, HttpServletRequest req){
        return build(HttpStatus.NOT_FOUND,ex,req);
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
}
