package com.service.financialanalyzer.service;

import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.repository.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionAggregationService {

    Logger logger = LogManager.getLogger(TransactionAggregationService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionAggregationDTO> getTransHistoryByCustomerID(Integer customerID) {
        logger.info("Service Method getTransHistoryByCustomerID called with customer ID " + customerID);
        return transactionRepository.getAggregatedTransactions(customerID);
    }

}
