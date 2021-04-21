package com.personal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public Map<String, String> exceptionHandler(BindException ex) {
		Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	if(error instanceof FieldError) {
	    		String fieldName = ((FieldError) error).getField();
	 	        String errorMessage = error.getDefaultMessage();
	 	        errors.put(fieldName, errorMessage);
	    	}else if(error instanceof ObjectError) {
	    		String fieldName = ((ObjectError) error).getCode();
	 	        String errorMessage = error.getDefaultMessage();
	 	        errors.put(fieldName, errorMessage);
	    	}
	    });
	    return errors;
	}
	
}