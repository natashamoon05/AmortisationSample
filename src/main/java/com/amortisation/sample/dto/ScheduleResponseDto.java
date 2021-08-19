package com.amortisation.sample.dto;

import java.util.List;
import java.util.Set;

import com.amortisation.sample.model.InstallmentRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ScheduleResponseDto {

	private String loanId;
	public double costOfAssest;
	private double deposit;
	private double yearlyRateOfInterest;
	private double noOfMonthlyPayments;
	private boolean isBalloonPayment;
	private double balloonPaymentAmount;
	private double totalInterestDue;
	private double totalPaymentsDue;
	@JsonInclude(Include.NON_NULL)
	private List<InstallmentRecord> installments;
	
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
	public double getTotalInterestDue() {
		return totalInterestDue;
	}
	public void setTotalInterestDue(double totalInterestDue) {
		this.totalInterestDue = totalInterestDue;
	}
	public double getTotalPaymentsDue() {
		return totalPaymentsDue;
	}
	public void setTotalPaymentsDue(double totalPaymentsDue) {
		this.totalPaymentsDue = totalPaymentsDue;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public List<InstallmentRecord> getInstallments() {
		return installments;
	}
	public void setInstallments(List<InstallmentRecord> installments) {
		this.installments = installments;
	}
}

