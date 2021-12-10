package com.service.financialanalyzer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.service.financialanalyzer.ApplicationConstants.RECORD_NOT_FOUND;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFoundException(
            RecordNotFoundException ex, WebRequest request) {

        Map<String, Object> exceptionMessage = new LinkedHashMap<>();
        exceptionMessage.put("timestamp", LocalDateTime.now());
        exceptionMessage.put("message", RECORD_NOT_FOUND);

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}
