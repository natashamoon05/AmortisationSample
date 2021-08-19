package com.amortisation.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class InstallmentRecord implements Comparable<InstallmentRecord> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer period;
	private double payment;
	private double prinipal;
	private double interest;
	private double balance;
	@ManyToOne
	@JoinColumn(name = "loan_id", nullable = false)
	@JsonIgnore
	private LoanDetails loanDetails;
	
	private boolean paymentDone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getPrinipal() {
		return prinipal;
	}
	public void setPrinipal(double prinipal) {
		this.prinipal = prinipal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LoanDetails getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}
	public boolean isPaymentDone() {
		return paymentDone;
	}
	public void setPaymentDone(boolean paymentDone) {
		this.paymentDone = paymentDone;
	}
	@Override
	public int compareTo(InstallmentRecord o) {
		return this.getPeriod().compareTo(o.getPeriod());
	}
}
