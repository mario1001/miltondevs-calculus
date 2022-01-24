package org.miltondevs.maven.miltondevscalculus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
public class ArithmeticControllerTestIT {

	@Autowired
	private ArithmeticController arithmeticController;
	
	@Test
	public void testSummaryBadRequestUniqueParameter() {
		List<Float> parameters = new ArrayList<>();
		parameters.add((float) 5.3);
		
		try {
			arithmeticController.summaryOperation(parameters);
		} catch (ResponseStatusException e) {
			assertEquals(e.getStatus(), HttpStatus.BAD_REQUEST);
			assertEquals(e.getReason(), "You must provide at least two query parameters");
		}
	}
	
	@Test
	public void testSummaryHTTPOkResponse() {
		List<Float> parameters = new ArrayList<>();
		parameters.add((float) 5.3);
		parameters.add((float) 5);
		parameters.add((float) 10.789);
		
		ResponseEntity<Float> response = arithmeticController.summaryOperation(parameters);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), (float) 21.08900);
	}
	
	@Test
	public void testSubtractHTTPOkResponse() {
		List<Float> parameters = new ArrayList<>();
		parameters.add((float) 2);
		parameters.add((float) 5);
		
		ResponseEntity<Float> response = arithmeticController.subtractOperation(parameters);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), (float) -3);
	}
}
