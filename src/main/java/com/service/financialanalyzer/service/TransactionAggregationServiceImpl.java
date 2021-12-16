package com.service.financialanalyzer.service;

import com.service.financialanalyzer.dto.CustomerDTO;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.exception.DuplicateEntryFoundException;
import com.service.financialanalyzer.exception.RecordNotFoundException;
import com.service.financialanalyzer.repository.CustomerRepository;
import com.service.financialanalyzer.repository.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionAggregationServiceImpl implements   TransactionService{

    Logger logger = LogManager.getLogger(TransactionAggregationServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
     ModelMapper modelMapper;

    @Override
    public List<TransactionAggregationDTO> getTransHistoryByCustomerID(Long customerID) throws RecordNotFoundException {

        logger.info("Service Method getTransHistoryByCustomerID called with customer ID " + customerID);
        customerRepository.findById(customerID).orElseThrow(RecordNotFoundException::new);

        return transactionRepository.getAggregatedTransactions(customerID);

    }

    @Transactional
    @Override
    public Customer addCustomer(CustomerDTO customerDto) throws DuplicateEntryFoundException {

        Customer customerEntity = modelMapper.map(customerDto, Customer.class);
        Customer customerCreated = null;
        try {
            customerCreated = customerRepository.saveAndFlush(customerEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryFoundException("Duplicate Entry found, Please verify the request parameters");
        }
        return customerCreated;
    }

}
