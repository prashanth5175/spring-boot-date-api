package com.personal.service;

import static com.personal.util.GeneralUtil.daysDiff;
import static com.personal.util.GeneralUtil.monthsDiff;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SeasoningCalculationRequestValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return SeasoningCalculationRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object req, Errors errors) {
		SeasoningCalculationRequest request = (SeasoningCalculationRequest)req;
		if (errors.getErrorCount() == 0) {
			long  numberOfPaymentsMade = monthsDiff(request.getFirstPaymentDueDate(),request.getPaymentDueDate());
			long  priorLoanSeasoningDays = daysDiff(request.getFirstPaymentDueDate(),request.getClosingDate());
			if(numberOfPaymentsMade<0) {
				errors.rejectValue("FirstPaymentDueDate", "INVALID","Payment Due date cannot be prior to the FirstPaymentDueDate");
//				errors.rejectValue(null,"Payment Due date cannot be prior to the FirstPaymentDueDate");
			}
			/*
			 * if(priorLoanSeasoningDays<0) { // errors.rejectValue("FirstPaymentDueDate",
			 * "INVALID","clsoing Due date cannot be prior to the FirstPaymentDueDate");
			 * errors.rejectValue(
			 * null,"clsoing Due date cannot be prior to the FirstPaymentDueDate"); }
			 */
		}
	}

}
