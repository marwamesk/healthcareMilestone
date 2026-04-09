package com.champsoft.healthcaremilestone.modules.billing.api;

import com.champsoft.healthcaremilestone.modules.billing.application.exception.BillingNotFoundException;
import com.champsoft.healthcaremilestone.modules.billing.application.exception.DuplicateBillingException;
import com.champsoft.healthcaremilestone.modules.billing.application.service.BillingCrudService;
import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidBillingException;
import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidInvoiceItemException;
import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidStatusRefund;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.Billing;
import com.champsoft.healthcaremilestone.shared.web.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = BillingController.class)
public class BillingExceptionHandler {

    @ExceptionHandler(BillingNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(BillingNotFoundException ex, HttpServletRequest req){
        return build(HttpStatus.NOT_FOUND,ex,req);
    }

    @ExceptionHandler(DuplicateBillingException.class)
    public ResponseEntity<ApiErrorResponse> conflict(DuplicateBillingException ex, HttpServletRequest req){
        return build(HttpStatus.CONFLICT,ex,req);
    }

    @ExceptionHandler({
            InvalidBillingException.class,
            InvalidInvoiceItemException.class,
            IllegalArgumentException.class,
            InvalidStatusRefund.class
    })
    public ResponseEntity<ApiErrorResponse> badRequest(RuntimeException ex, HttpServletRequest req){
        return build(HttpStatus.BAD_REQUEST,ex,req);
    }


    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse>
    badRequest(org.springframework.web.bind.MethodArgumentNotValidException ex,
               HttpServletRequest req){

        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(err -> err.getField()+" "+ err.getDefaultMessage()).orElse("Failed");
        return build(HttpStatus.BAD_REQUEST,new IllegalArgumentException(message),req);

    }

    private ResponseEntity<ApiErrorResponse> build(HttpStatus status,Exception ex,HttpServletRequest req){
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
