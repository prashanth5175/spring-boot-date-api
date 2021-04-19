package com.personal.service;

import javax.validation.constraints.Pattern;

public class SeasoningCalculationRequest {

	
	@Pattern(regexp="^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$", message=" paymentDueDate is not valid" ) String paymentDueDate;
	@Pattern(regexp="^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$", message=" firstPaymentDueDate  is not valid " ) String firstPaymentDueDate;
	@Pattern(regexp="^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$", message="Closing date is not valid" ) String closingDate;
	
	public String getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public String getFirstPaymentDueDate() {
		return firstPaymentDueDate;
	}
	public void setFirstPaymentDueDate(String firstPaymentDueDate) {
		this.firstPaymentDueDate = firstPaymentDueDate;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	
}
