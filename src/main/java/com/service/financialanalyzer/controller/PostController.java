package com.service.financialanalyzer.controller;

import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.CustomerDTO;
import com.service.financialanalyzer.service.TransactionAggregationService;
import org.springframework.beans.BeanUtils;
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
    TransactionAggregationService service;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customerDTO) throws MethodArgumentNotValidException {

        Customer customerEntity = new Customer();
        BeanUtils.copyProperties(customerDTO, customerEntity);

        Customer customerCreated = service.addCustomer(customerEntity);
        BeanUtils.copyProperties(customerCreated, customerDTO);

        return  new ResponseEntity<>("Customer ID created successfully : " + customerCreated.getCustomerId() , HttpStatus.OK);
    }
}
