package org.miltondevs.maven.miltondevscalculus.controller;

import java.util.List;

import org.miltondevs.maven.miltondevscalculus.service.IArithmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.corp.calculator.TracerImpl;

/**
 * API REST Controller for arithmetic operations.
 * 
 * Contains for now only two operations: summary and subtract applied to query
 * parameters in a list.
 * 
 * @author Mario Benito Rodriguez
 *
 */
@RestController
@RequestMapping("/arithmetic")
public class ArithmeticController {

	private IArithmeticService arithmeticService;
	
	// TracerImpl class is not implementing the interface at all 
	// (this should be TracerAPI as type instead)
	private TracerImpl tracerAPI;

	/**
	 * Creates a new arithmetic controller with service associated.
	 * 
	 * @param arithmeticService Arithmetic service instance to serve this controller
	 */
	@Autowired
	public ArithmeticController(IArithmeticService arithmeticService) {
		this.arithmeticService = arithmeticService;
		this.tracerAPI = new TracerImpl();
	}

	private void validate(List<Float> parameters) {
		if (parameters.size() == 1) {
			// Throw bad request exception in this case
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"You must provide at least two query parameters");
		}
	}
	
	private <T> void registerOperation(T result) {
		tracerAPI.trace(result);
	}

	/**
	 * Applies the summary of a list of query parameters.
	 * 
	 * Parameters must be provided along & as query parameters associated to the
	 * param tag.
	 * 
	 * @param parameters
	 * @return The summary of parameters
	 */
	@GetMapping("/addition")
	public ResponseEntity<Float> additionOperation(
			@RequestParam(name = "param") List<Float> parameters) {
		validate(parameters);
		
		float result = arithmeticService.additionOperation(parameters);
		
		registerOperation(result);
		return ResponseEntity.ok(result);
	}

	/**
	 * Applies the subtraction of a list of query parameters.
	 * 
	 * Parameters must be provided along & as query parameters associated to the
	 * param tag.
	 * 
	 * @param parameters
	 * @return The subtraction of the parameters
	 */
	@GetMapping("/subtract")
	public ResponseEntity<Float> subtractOperation(
			@RequestParam(name = "param") List<Float> parameters) {
		validate(parameters);
		
		float result = arithmeticService.subtractOperation(parameters);
		
		registerOperation(result);
		return ResponseEntity.ok(result);
	}

}
