package com.amortisation.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amortisation.sample.model.InstallmentRecord;

public interface InstallmentRecordRepository extends JpaRepository<InstallmentRecord, String> {
	
	@Query(value = " SELECT top 1 * FROM installment_record ir WHERE ir.loan_id = ?1 "
			  		+ " and ir.payment_done = false order by period asc", 
			  nativeQuery = true)
	Optional<InstallmentRecord> findByLoanInEarliestPaymentDue(String loanId);

}
