package com.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.personal.service.SeasoningCalculationRequest;
import com.personal.service.SeasoningResponse;
import com.personal.service.SeasoningSerivce;

@SpringBootTest
public class SeasoningSerivceTest {

	@InjectMocks
	private SeasoningSerivce seasoningSerivce;
	
	
	@Test
	public void testCalculateScenario1() {
		
		SeasoningCalculationRequest seasoningCalculationRequest = Mockito.mock(SeasoningCalculationRequest.class);
		
		Mockito.when(seasoningCalculationRequest.getFirstPaymentDueDate()).thenReturn("01/01/2020");
		Mockito.when(seasoningCalculationRequest.getPaymentDueDate()).thenReturn("02/01/2021");
		Mockito.when(seasoningCalculationRequest.getClosingDate()).thenReturn( "02/15/2021");
		
		SeasoningResponse res = seasoningSerivce.calculate(seasoningCalculationRequest);
		assertEquals("YES", res.getDoesLoanMeetSeasoningDaysRequirement());
		assertEquals("YES", res.getDoesLoanMeetSeasoningPaymentNumberRequirement());
		assertEquals(13, res.getNumberOfPaymentsMade());
		assertEquals(411, res.getPriorLoanSeasoningDays());

	}
	
	
}
