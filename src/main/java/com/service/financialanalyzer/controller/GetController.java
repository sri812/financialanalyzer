package com.service.financialanalyzer.controller;

import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.exception.RecordNotFoundException;
import com.service.financialanalyzer.service.TransactionAggregationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static com.service.financialanalyzer.ApplicationConstants.*;

@RestController
@RequestMapping(CUSTOMER_API)
public class GetController {

    Logger logger = LogManager.getLogger(GetController.class);

    @Autowired
    private TransactionAggregationServiceImpl transactionService;

    @GetMapping(CUSTOMER_AGGREGATED_TRANSACTION)
    public List<TransactionAggregationDTO> getTransHistoryByCustomerID(@PathVariable @NotBlank(message = "Customer ID cannot be empty") Long customerID) throws RecordNotFoundException {
        logger.info("Inside Controller Method getTransHistoryByCustomerID with customer ID " + customerID);

        List<TransactionAggregationDTO>  transactions = transactionService.getTransHistoryByCustomerID(customerID);
        if(transactions.isEmpty()) {
            logger.error("Controller Method getTransHistoryByCustomerID; customer ID not found. " + customerID);
            throw new RecordNotFoundException();
        }
        return transactions;
    }

}
