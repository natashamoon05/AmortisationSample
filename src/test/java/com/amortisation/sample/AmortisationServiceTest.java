package com.amortisation.sample;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amortisation.sample.dto.ScheduleRequest;
import com.amortisation.sample.dto.ScheduleResponseDto;
import com.amortisation.sample.model.InstallmentRecord;
import com.amortisation.sample.model.LoanDetails;
import com.amortisation.sample.repository.InstallmentRecordRepository;
import com.amortisation.sample.repository.LoanDetailsRepository;
import com.amortisation.sample.service.AmortisationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
public class AmortisationServiceTest {
	@Mock
	private LoanDetailsRepository loanDetailsRepository;
	@Mock
	private InstallmentRecordRepository installmentRecordRepository;
	@Autowired
	private AmortisationService amortisationService;

	@Test
	public void shouldsaveLoanDetailsAndCreateInstallmentRecordsWhenRequestIsValidAndWithoutBalloon() {
		ScheduleRequest request = TestData.aValidScheduleCreationWithoutBalloonRequest();
		when(loanDetailsRepository.save(any())).thenReturn(TestData.avalidLoanDetailsResponse());
		LoanDetails l = amortisationService.createAmortisationSchedule(request);

		Assertions.assertNotNull(l, "The Save Loan Details Object is not null");
		Assertions.assertNotNull(l.getLoanId(), "The Loan details ID increament by auto number starting from 1");

		Assertions.assertNotNull(l.getInstallments(), "The installments should be created");
		Assertions.assertEquals(request.getNoOfMonthlyPayments(), l.getInstallments().size());

		InstallmentRecord lastInstallmet = l.getInstallments().get(l.getInstallments().size() - 1);
		Assertions.assertEquals(0, lastInstallmet.getBalance());
	}

	@Test
	public void shouldsaveLoanDetailsAndCreateInstallmentRecordsWhenRequestIsValidAndWithBalloon() {
		ScheduleRequest request = TestData.aValidScheduleCreationWithBalloonRequest();
		when(loanDetailsRepository.save(any())).thenReturn(TestData.avalidLoanDetailsResponse());
		LoanDetails l = amortisationService.createAmortisationSchedule(request);

		Assertions.assertNotNull(l, "The Save Loan Details Object is not null");
		Assertions.assertNotNull(l.getLoanId(), "The Loan details ID increament by auto number starting from 1");

		Assertions.assertNotNull(l.getInstallments(), "The installments should be created");
		Assertions.assertEquals(request.getNoOfMonthlyPayments(), l.getInstallments().size());

		InstallmentRecord lastInstallmet = l.getInstallments().get(l.getInstallments().size() - 1);
		Assertions.assertEquals(request.getBalloonPaymentAmount(), lastInstallmet.getBalance());
	}

	@Test	
	public void shouldgetListOfLoanDetails() throws JsonParseException, JsonMappingException, IOException {
			List<ScheduleResponseDto> response = TestData.getListOfLoanDetails();
			List<ScheduleResponseDto> actuaResponse = amortisationService.getListOFAmortisationSchedule();
			
			Assertions.assertEquals(2, actuaResponse.size());
	}
	
	@Test
	public void shouldgetLoanDetailsWithAmortizationScheduleGivenLoanId() throws Exception {
		ScheduleResponseDto expectedResponse = TestData.getLoanDetails();
		ScheduleResponseDto actuaResponse = amortisationService.getFAmortisationSchedule("1");
		
		Assertions.assertEquals(expectedResponse.getInstallments().size(), actuaResponse.getInstallments().size());
		Assertions.assertEquals(1, actuaResponse.getLoanId());
	}
}
