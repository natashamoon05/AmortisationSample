package com.amortisation.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleRequest {

	public double costOfAssest;
	private double deposit;
	private double yearlyRateOfInterest;
	private int noOfMonthlyPayments;
	private boolean balloonPayment;
	private double balloonPaymentAmount;
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
	public int getNoOfMonthlyPayments() {
		return noOfMonthlyPayments;
	}
	public void setNoOfMonthlyPayments(int noOfMonthlyPayments) {
		this.noOfMonthlyPayments = noOfMonthlyPayments;
	}
	public boolean isBalloonPayment() {
		return balloonPayment;
	}
	public void setBalloonPayment(boolean isBalloonPayment) {
		this.balloonPayment = isBalloonPayment;
	}
	public double getBalloonPaymentAmount() {
		return balloonPaymentAmount;
	}
	public void setBalloonPaymentAmount(double balloonPaymentAmount) {
		this.balloonPaymentAmount = balloonPaymentAmount;
	}


}

