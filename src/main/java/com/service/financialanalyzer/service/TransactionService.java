package com.service.financialanalyzer.service;

import com.service.financialanalyzer.dto.CustomerDTO;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.exception.RecordNotFoundException;

import java.util.List;

public interface TransactionService {
    public List<TransactionAggregationDTO> getTransHistoryByCustomerID(Long customerID) throws RecordNotFoundException;
    public Customer addCustomer(CustomerDTO customerDto);
}
