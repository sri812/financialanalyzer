package com.service.financialanalyzer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private Date date;
    private String errorMessage;
    private String endpoint;
    private String reasonPhrase;
}
