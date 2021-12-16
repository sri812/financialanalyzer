package com.service.financialanalyzer.repository;

import com.service.financialanalyzer.entity.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEmailRepository extends JpaRepository<CustomerEmail, Integer> {

}