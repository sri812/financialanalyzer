package com.service.financialanalyzer.service;

import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.CustomerDTO;
import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.exception.RecordNotFoundException;
import com.service.financialanalyzer.repository.CustomerRepository;
import com.service.financialanalyzer.repository.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionAggregationService {

    Logger logger = LogManager.getLogger(TransactionAggregationService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<TransactionAggregationDTO> getTransHistoryByCustomerID(Long customerID) throws RecordNotFoundException {

        logger.info("Service Method getTransHistoryByCustomerID called with customer ID " + customerID);
        customerRepository.findById(customerID).orElseThrow(RecordNotFoundException::new);

        return transactionRepository.getAggregatedTransactions(customerID);

    }

//    @Transactional
    public Customer addCustomer(Customer customerEntity) {

        return customerRepository.save(customerEntity);
    }


}
