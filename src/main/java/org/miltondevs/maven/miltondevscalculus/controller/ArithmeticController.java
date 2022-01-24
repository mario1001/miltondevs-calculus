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

	/**
	 * Creates a new arithmetic controller with service associated.
	 * 
	 * @param arithmeticService Arithmetic service instance to serve this controller
	 */
	@Autowired
	public ArithmeticController(IArithmeticService arithmeticService) {
		this.arithmeticService = arithmeticService;
	}

	private void validate(List<Float> parameters) {
		if (parameters.size() == 1) {
			// Throw bad request exception in this case
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"You must provide at least two query parameters");
		}
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
	@GetMapping("/summary")
	public ResponseEntity<Float> summaryOperation(
			@RequestParam(name = "param") List<Float> parameters) {
		this.validate(parameters);
		return ResponseEntity.ok(this.arithmeticService.summaryOperation(parameters));
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
	@GetMapping("/substract")
	public ResponseEntity<Float> subtractOperation(
			@RequestParam(name = "param") List<Float> parameters) {
		this.validate(parameters);
		return ResponseEntity.ok(this.arithmeticService.subtractOperation(parameters));
	}

}
