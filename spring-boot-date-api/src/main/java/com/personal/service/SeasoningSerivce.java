package com.personal.service;

import static com.personal.util.GeneralUtil.NO;
import static com.personal.util.GeneralUtil.YES;
import static com.personal.util.GeneralUtil.daysDiff;
import static com.personal.util.GeneralUtil.monthsDiff;

import org.springframework.stereotype.Service;

@Service
public class SeasoningSerivce {

	private static long paymentsThreashold = 6;
	private static long paymentDaysThreashold = 180;
	
	public SeasoningResponse calculate(String paymentDueDate , String firstPaymentDueDate , String closingDate ) {
		long  numberOfPaymentsMade = monthsDiff(firstPaymentDueDate,paymentDueDate);
		long  priorLoanSeasoningDays = daysDiff(firstPaymentDueDate,paymentDueDate);
		SeasoningResponse res = new SeasoningResponse();
		res.setNumberOfPaymentsMade(numberOfPaymentsMade);
		res.setPriorLoanSeasoningDays(priorLoanSeasoningDays);
		if(numberOfPaymentsMade>=paymentsThreashold) {
			res.setDoesLoanMeetSeasoningPaymentNumberRequirement(YES);
		}else {
			res.setDoesLoanMeetSeasoningPaymentNumberRequirement(NO);
		}
		
		if(priorLoanSeasoningDays>=paymentDaysThreashold) {
			res.setDoesLoanMeetSeasoningDaysRequirement(YES);
		}else {
			res.setDoesLoanMeetSeasoningDaysRequirement(NO);
		}
		return res;
	}
	
}
