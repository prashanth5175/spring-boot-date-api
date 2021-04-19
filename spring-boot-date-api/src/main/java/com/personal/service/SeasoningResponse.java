package com.personal.service;

import lombok.Data;

@Data
public class SeasoningResponse {
	
	private long numberOfPaymentsMade;
	private long priorLoanSeasoningDays;
	private String doesLoanMeetSeasoningDaysRequirement;
	private String doesLoanMeetSeasoningPaymentNumberRequirement;
	
	public long getNumberOfPaymentsMade() {
		return numberOfPaymentsMade;
	}
	public void setNumberOfPaymentsMade(long numberOfPaymentsMade) {
		this.numberOfPaymentsMade = numberOfPaymentsMade;
	}
	public long getPriorLoanSeasoningDays() {
		return priorLoanSeasoningDays;
	}
	public void setPriorLoanSeasoningDays(long priorLoanSeasoningDays) {
		this.priorLoanSeasoningDays = priorLoanSeasoningDays;
	}
	public String getDoesLoanMeetSeasoningDaysRequirement() {
		return doesLoanMeetSeasoningDaysRequirement;
	}
	public void setDoesLoanMeetSeasoningDaysRequirement(String doesLoanMeetSeasoningDaysRequirement) {
		this.doesLoanMeetSeasoningDaysRequirement = doesLoanMeetSeasoningDaysRequirement;
	}
	public String getDoesLoanMeetSeasoningPaymentNumberRequirement() {
		return doesLoanMeetSeasoningPaymentNumberRequirement;
	}
	public void setDoesLoanMeetSeasoningPaymentNumberRequirement(String doesLoanMeetSeasoningPaymentNumberRequirement) {
		this.doesLoanMeetSeasoningPaymentNumberRequirement = doesLoanMeetSeasoningPaymentNumberRequirement;
	}
	
	
	
	
}
