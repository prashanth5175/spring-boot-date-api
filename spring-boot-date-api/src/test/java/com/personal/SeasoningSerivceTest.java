package com.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.personal.service.SeasoningResponse;
import com.personal.service.SeasoningSerivce;

@SpringBootTest
public class SeasoningSerivceTest {

	@InjectMocks
	private SeasoningSerivce seasoningSerivce;
	
	@Test
	public void testCalculateScenario1() {
		
		SeasoningResponse res = seasoningSerivce.calculate("2021/04/13", "2020/03/13", "2022/04/13");
		assertEquals("YES", res.getDoesLoanMeetSeasoningDaysRequirement());
		assertEquals("YES", res.getDoesLoanMeetSeasoningPaymentNumberRequirement());
		assertEquals(13, res.getNumberOfPaymentsMade());
		assertEquals(396, res.getPriorLoanSeasoningDays());
		
		
	}
	
	@Test
	public void testCalculateScenario2() {
		SeasoningResponse res = seasoningSerivce.calculate("2021/04/13", "2021/03/13", "2022/04/13");
		assertEquals("NO", res.getDoesLoanMeetSeasoningDaysRequirement());
		assertEquals("NO", res.getDoesLoanMeetSeasoningPaymentNumberRequirement());
		assertEquals(1, res.getNumberOfPaymentsMade());
		assertEquals(31, res.getPriorLoanSeasoningDays());
	}
	
}
