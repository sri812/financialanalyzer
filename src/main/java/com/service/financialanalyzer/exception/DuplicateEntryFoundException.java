package com.service.financialanalyzer.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateEntryFoundException extends DataIntegrityViolationException {

    public DuplicateEntryFoundException(String message) {
        super(message);
    }

}

