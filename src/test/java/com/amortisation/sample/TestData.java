package com.amortisation.sample;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.amortisation.sample.dto.ScheduleRequest;
import com.amortisation.sample.dto.ScheduleResponseDto;
import com.amortisation.sample.model.LoanDetails;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData {

	public static ScheduleRequest aValidScheduleCreationWithoutBalloonRequest() {
		ScheduleRequest req = new ScheduleRequest();
		req.setCostOfAssest(25000);
		req.setDeposit(5000);
		req.setNoOfMonthlyPayments(3);
		req.setYearlyRateOfInterest(7.5);
		req.setBalloonPayment(false);
		return req;
	}

	public static LoanDetails avalidLoanDetailsResponse() {
		LoanDetails l = new LoanDetails();
		l.setCostOfAssest(25000);
		l.setDeposit(5000);
		l.setNoOfMonthlyPayments(3);
		l.setYearlyRateOfInterest(7.5);
		l.setBalloonPayment(false);
		return l;
	}

	public static ScheduleRequest aValidScheduleCreationWithBalloonRequest() {
		ScheduleRequest req = new ScheduleRequest();
		req.setCostOfAssest(25000);
		req.setDeposit(5000);
		req.setNoOfMonthlyPayments(3);
		req.setYearlyRateOfInterest(7.5);
		req.setBalloonPayment(true);
		req.setBalloonPaymentAmount(10000);
		return req;
	}

	public static List<ScheduleResponseDto> getListOfLoanDetails()
			throws JsonParseException, JsonMappingException, IOException {

		List<ScheduleResponseDto> response = new ObjectMapper().readValue(
				new File("/Amortisation-Demo/src/main/resources/expected/ListOfLoanDetails.json"),
				new TypeReference<List<ScheduleResponseDto>>() {
				});
		return response;
	}

	public static ScheduleResponseDto getLoanDetails()
			throws JsonParseException, JsonMappingException, IOException {

		ScheduleResponseDto expectedResponse = new ObjectMapper().readValue(
				new File("/Amortisation-Demo/src/main/resources/expected/GetSingleLoanDetails.json"),
				ScheduleResponseDto.class);
		return expectedResponse;
	}
}
