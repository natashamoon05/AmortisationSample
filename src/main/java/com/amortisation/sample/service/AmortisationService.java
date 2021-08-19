package com.amortisation.sample.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amortisation.sample.dto.ScheduleRequest;
import com.amortisation.sample.dto.ScheduleResponseDto;
import com.amortisation.sample.model.InstallmentRecord;
import com.amortisation.sample.model.LoanDetails;
import com.amortisation.sample.repository.InstallmentRecordRepository;
import com.amortisation.sample.repository.LoanDetailsRepository;

@Service
public class AmortisationService {
	
	@Autowired
	LoanDetailsRepository loanDetailsRepository;
	
	@Autowired
	InstallmentRecordRepository installmentRecordRepository;
	
	DecimalFormat df = new DecimalFormat("#.##");

	public LoanDetails createAmortisationSchedule(ScheduleRequest request) {
		LoanDetails loanDetails = createLoanDetailsEntity(request);
		
		double P = request.getCostOfAssest() - request.getDeposit();
		double r = (request.getYearlyRateOfInterest() * 0.01) / 12;
		double n = request.getNoOfMonthlyPayments();
		
		if(request.isBalloonPayment()) {
			//(P-(B/((1+r)^n)))*(r/1-(1+r)^-n)
			double B = request.getBalloonPaymentAmount();
			double monthlyRepayment = Double.valueOf(df.format((P-(B/(Math.pow(1+r,n)))) *(r / (1 - Math.pow(1+r, -n)))));
			for (int i = 1 ; i <= n ; i++) {
				double interest = Double.valueOf(df.format(P * r));
				double principal = Double.valueOf(df.format(monthlyRepayment - interest));
				P = Double.valueOf(df.format(P - principal));
				createNewInstallmentRecord (loanDetails, i,monthlyRepayment, principal,interest, P);
			}
		} else {
			//P*((r*(1+r)^n)/((1+r)^n-1))
			double monthlyRepayment = Double.valueOf(df.format(P*((r* Math.pow(1+r, n))/(Math.pow(1+r, n)-1))));
			for (int i = 1 ; i <= n ; i++) {
				double interest = Double.valueOf(df.format(P * r));
				double principal = Double.valueOf(df.format(monthlyRepayment - interest));
				P = Double.valueOf(df.format(P - principal));
				createNewInstallmentRecord (loanDetails, i,monthlyRepayment, principal,interest, P);
			}
			
		}
		return loanDetails;
	}

	private void createNewInstallmentRecord(LoanDetails loanDetails, int i, double monthlyRepayment,
			double principal, double interest, double balance) {
		InstallmentRecord instRecord = new InstallmentRecord();
		instRecord.setPeriod(i);
		instRecord.setPayment(monthlyRepayment);
		instRecord.setPrinipal(principal);
		instRecord.setInterest(interest);
		instRecord.setLoanDetails(loanDetails);
		instRecord.setBalance(balance);
		installmentRecordRepository.save(instRecord);
	}

	private LoanDetails createLoanDetailsEntity(ScheduleRequest request) {
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setCostOfAssest(request.getCostOfAssest());
		loanDetails.setDeposit(request.getDeposit());
		loanDetails.setNoOfMonthlyPayments(request.getNoOfMonthlyPayments());
		loanDetails.setYearlyRateOfInterest(request.getYearlyRateOfInterest());
		loanDetails.setBalloonPayment(request.isBalloonPayment());
		if(request.isBalloonPayment()) {
			loanDetails.setBalloonPaymentAmount(request.getBalloonPaymentAmount());
		}
		loanDetailsRepository.save(loanDetails);
		return loanDetails;
	}

	public List<ScheduleResponseDto> getListOFAmortisationSchedule() {
		List<LoanDetails> listOfLoans = loanDetailsRepository.findAll();
		List<ScheduleResponseDto> listOfSchedules = new ArrayList<ScheduleResponseDto>();
		for(LoanDetails l : listOfLoans) {
			ScheduleResponseDto res = getLoanDetails(l);
			listOfSchedules.add(res);
		}
		return listOfSchedules;
	}

	private ScheduleResponseDto getLoanDetails(LoanDetails l) {
		ScheduleResponseDto res = new ScheduleResponseDto();
		res.setLoanId(l.getLoanId());
		res.setCostOfAssest(l.getCostOfAssest());
		res.setDeposit(l.getDeposit());
		res.setNoOfMonthlyPayments(l.getNoOfMonthlyPayments());
		res.setYearlyRateOfInterest(l.getYearlyRateOfInterest());
		res.setBalloonPayment(l.isBalloonPayment());
		res.setBalloonPaymentAmount(l.getBalloonPaymentAmount());
		double interestDue = 0;
		int paymentsDue = 0;
		for (InstallmentRecord inst :l.getInstallments() ) {
			if(!inst.isPaymentDone()) {
				interestDue = interestDue + inst.getInterest();
				paymentsDue++;
			}
		}
		res.setTotalInterestDue(Double.valueOf(df.format(interestDue)));
		res.setTotalPaymentsDue(Double.valueOf(df.format(paymentsDue)));
		return res;
	}

	public ScheduleResponseDto getFAmortisationSchedule(String loanId) throws Exception {
		Optional<LoanDetails> loan = loanDetailsRepository.findById(loanId);
		if(loan.isPresent()) {
			ScheduleResponseDto res = getLoanDetails(loan.get());
			Collections.sort(loan.get().getInstallments());
			res.setInstallments(loan.get().getInstallments());
			return res;
		} else {
			throw new Exception ("Loan with given id does not exists");
		}
		
	}

	public void makePayment(String loanId) throws Exception {
		Optional<InstallmentRecord> inst = installmentRecordRepository.findByLoanInEarliestPaymentDue(loanId);
		if(inst.isPresent()) {
			inst.get().setPaymentDone(true);
			installmentRecordRepository.save(inst.get());
		} else {
			throw new Exception ("Non Paid Installment with given Loan id does not exists");
		}
	}
}
