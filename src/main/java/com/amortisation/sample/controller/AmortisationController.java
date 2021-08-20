package com.amortisation.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amortisation.sample.dto.ScheduleRequest;
import com.amortisation.sample.dto.ScheduleResponseDto;
import com.amortisation.sample.service.AmortisationService;

@RestController
public class AmortisationController {

	@Autowired
	AmortisationService amortisationService;
	
	@PostMapping("/createAmotisationSchedule")
	public ResponseEntity<String> createSchedule (@RequestBody ScheduleRequest requestBody) {
		amortisationService.createAmortisationSchedule(requestBody);
		return new ResponseEntity<String>("Schedule Created Successfully !" , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllSchedules")
	public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules (){
		List<ScheduleResponseDto> scheduleList = amortisationService.getListOFAmortisationSchedule();
		return new ResponseEntity<List<ScheduleResponseDto>>(scheduleList, HttpStatus.OK);
	}
	
	@GetMapping("/getAmortisationSchedule")
	public ResponseEntity<ScheduleResponseDto> getAmortisationSchedule (@RequestParam(required = false) String loanId) throws Exception{
		ScheduleResponseDto scheduleDetails = amortisationService.getFAmortisationSchedule(loanId);
		return new ResponseEntity<ScheduleResponseDto>(scheduleDetails, HttpStatus.OK);
	}
	
	@PatchMapping("/markPaymentDone")
	public ResponseEntity<String> makeLoanPayment(@RequestParam(required = false) String loanId) throws Exception {
		amortisationService.makePayment(loanId);
		return new ResponseEntity<String>("Payment Done Successfully for Loan Id : " + loanId , HttpStatus.ACCEPTED);
		
	}
}
