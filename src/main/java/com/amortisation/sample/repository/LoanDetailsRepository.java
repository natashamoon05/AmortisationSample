package com.amortisation.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amortisation.sample.model.LoanDetails;

public interface LoanDetailsRepository extends JpaRepository<LoanDetails, String> {

}
