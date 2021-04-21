package com.personal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import com.personal.service.SeasoningCalculationRequest;
import com.personal.service.SeasoningCalculationRequestValidator;
import com.personal.service.SeasoningResponse;
import com.personal.service.SeasoningSerivce;

@RestController
public class SeasoningController {
	
	@Autowired
	private SeasoningSerivce service;
	
	@Autowired
	private SeasoningCalculationRequestValidator validator;
	
	@InitBinder("seasoningCalculationRequest")
    public void initMerchantOnlyBinder(WebDataBinder binder) {
		binder.addValidators(validator);
    }
	
	@GetMapping("/seasoning")
	public SeasoningResponse get(@Valid SeasoningCalculationRequest seasoningCalculationRequest) {
		return service.calculate(seasoningCalculationRequest);
	}
	
}