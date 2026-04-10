package com.champsoft.healthcaremilestone.modules.appointment.api;

import com.champsoft.healthcaremilestone.modules.appointment.domain.exception.AppointmentNotFoundException;
import com.champsoft.healthcaremilestone.modules.appointment.domain.exception.DoctorNotFoundException;
import com.champsoft.healthcaremilestone.modules.appointment.domain.exception.TimeSlotConflictException;
import com.champsoft.healthcaremilestone.shared.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

public class AppointmentExceptionHandler {

        @ExceptionHandler(AppointmentNotFoundException.class)
        public ResponseEntity<ApiErrorResponse> handleNotFound(
                AppointmentNotFoundException ex,
                HttpServletRequest req
        ) {
            return build(HttpStatus.NOT_FOUND, ex, req);
        }

        @ExceptionHandler(DoctorNotFoundException.class)
        public ResponseEntity<ApiErrorResponse> handleDoctor(
                DoctorNotFoundException ex,
                HttpServletRequest req
        ) {
            return build(HttpStatus.BAD_REQUEST, ex, req);
        }

        @ExceptionHandler(TimeSlotConflictException.class)
        public ResponseEntity<ApiErrorResponse> handleConflict(
                TimeSlotConflictException ex,
                HttpServletRequest req
        ) {
            return build(HttpStatus.CONFLICT, ex, req);
        }

        private ResponseEntity<ApiErrorResponse> build(HttpStatus status, Exception ex, HttpServletRequest req) {
            return ResponseEntity.status(status).body(
                    new ApiErrorResponse(
                            Instant.now(),
                            status.value(),
                            status.getReasonPhrase(),
                            ex.getMessage(),
                            req.getRequestURI()
                    )
            );
        }
    }

