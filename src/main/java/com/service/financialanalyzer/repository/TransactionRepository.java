package com.service.financialanalyzer.repository;

import com.service.financialanalyzer.entity.TransactionAggregationDTO;
import com.service.financialanalyzer.entity.CustomerTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.service.financialanalyzer.ApplicationConstants.TRANSACTION_SUMMARY_QUERY;

@Repository
public interface TransactionRepository extends CrudRepository<CustomerTransaction, Long> {

    @Query(value = TRANSACTION_SUMMARY_QUERY, nativeQuery = true)
     List<TransactionAggregationDTO> getAggregatedTransactions(Long customerID);
}

