package com.amortisation.sample.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String loanId;
	
	private double costOfAssest;
	private double deposit;
	private double yearlyRateOfInterest;
	private double noOfMonthlyPayments;
	private boolean isBalloonPayment;
	private double balloonPaymentAmount;
	
	@OneToMany(mappedBy="loanDetails")
	private List<InstallmentRecord> installments;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public double getCostOfAssest() {
		return costOfAssest;
	}

	public void setCostOfAssest(double costOfAssest) {
		this.costOfAssest = costOfAssest;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getYearlyRateOfInterest() {
		return yearlyRateOfInterest;
	}

	public void setYearlyRateOfInterest(double yearlyRateOfInterest) {
		this.yearlyRateOfInterest = yearlyRateOfInterest;
	}

	public double getNoOfMonthlyPayments() {
		return noOfMonthlyPayments;
	}

	public void setNoOfMonthlyPayments(double noOfMonthlyPayments) {
		this.noOfMonthlyPayments = noOfMonthlyPayments;
	}

	public boolean isBalloonPayment() {
		return isBalloonPayment;
	}

	public void setBalloonPayment(boolean isBalloonPayment) {
		this.isBalloonPayment = isBalloonPayment;
	}

	public double getBalloonPaymentAmount() {
		return balloonPaymentAmount;
	}

	public void setBalloonPaymentAmount(double balloonPaymentAmount) {
		this.balloonPaymentAmount = balloonPaymentAmount;
	}

	public List<InstallmentRecord> getInstallments() {
		return installments;
	}

	public void setInstallments(List<InstallmentRecord> installments) {
		this.installments = installments;
	}
	
}
