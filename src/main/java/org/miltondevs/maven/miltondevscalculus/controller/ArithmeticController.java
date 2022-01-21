package org.miltondevs.maven.miltondevscalculus.controller;

import java.util.List;

import org.miltondevs.maven.miltondevscalculus.service.IArithmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST Controller for arithmetic operations.
 * 
 * Constains for now only two operations: summary and substract
 * applied to query parameters in a list.
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
	 * @param arithmeticService Arithmetic service instance to serve this endpoint
	 */
	@Autowired
	public ArithmeticController(IArithmeticService arithmeticService) {
		this.arithmeticService = arithmeticService;
	}
	
	/**
	 * Applies the summary of a list of query parameters.
	 * 
	 * Parameters must be provided along & as query parameters associated
	 * to the param tag.
	 * 
	 * @param parameters
	 * @return
	 */
	@GetMapping("/summary")
	public ResponseEntity<Float> summaryOperation(@RequestParam(name = "param") List<Float> parameters) {
		return ResponseEntity.ok(this.arithmeticService.summaryOperation(parameters));
	}
	
	/**
	 * Applies the substraction of a list of query parameters.
	 * 
	 * Parameters must be provided along & as query parameters associated
	 * to the param tag.
	 * 
	 * @param parameters
	 * @return
	 */
	@GetMapping("/substract")
	public ResponseEntity<Float> substractOperation(@RequestParam(name = "param") List<Float> parameters) {
		return ResponseEntity.ok(this.arithmeticService.substractOperation(parameters));
	}
	
}
