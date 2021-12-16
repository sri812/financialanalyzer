package com.service.financialanalyzer.controller;

import com.service.financialanalyzer.dto.CustomerDTO;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.exception.DuplicateEntryFoundException;
import com.service.financialanalyzer.service.TransactionAggregationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.service.financialanalyzer.ApplicationConstants.CUSTOMER_API;

@RestController
@RequestMapping(CUSTOMER_API)
public class PostController {

    @Autowired
    TransactionAggregationServiceImpl service;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDTO customerDto)
            throws MethodArgumentNotValidException, DuplicateEntryFoundException {

        Customer customerCreated = service.addCustomer(customerDto);
        return  new ResponseEntity<>("Customer ID created successfully : " + customerCreated.getCustomerId() , HttpStatus.OK);
    }
}
