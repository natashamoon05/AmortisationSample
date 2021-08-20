package com.amortisation.sample;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.amortisation.sample.service.AmortisationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class AmortisationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AmortisationService amortisationService;
	
	 
	@Test
	public void shouldCreateLoanDetailsAnAmortisationSchedule() throws Exception {
		when (amortisationService.createAmortisationSchedule(TestData.aValidScheduleCreationWithoutBalloonRequest())).thenReturn(TestData.avalidLoanDetailsResponse());
		  
		mockMvc
	    .perform(
	      post("/createAmotisationSchedule")
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(new ObjectMapper().writeValueAsString(TestData.aValidScheduleCreationWithoutBalloonRequest()))
	    )
	    .andExpect(status().isCreated());
	
	}
	
	@Test
	public void shouldGetListOfAllSchedules() throws Exception {
		when (amortisationService.getListOFAmortisationSchedule()).thenReturn(TestData.getListOfLoanDetails());
		mockMvc
	    .perform(
	      get("/getAllSchedules")
	    )
	    .andExpect(status().isOk());	
	}
	
	@Test
	public void shouldGetLoanDetailsGivenId() throws Exception {
		when (amortisationService.getFAmortisationSchedule("1")).thenReturn(TestData.getLoanDetails());
		mockMvc
	    .perform(
	      get("/getAllSchedules")
	    )
	    .andExpect(status().isOk());	
	}
	

}
