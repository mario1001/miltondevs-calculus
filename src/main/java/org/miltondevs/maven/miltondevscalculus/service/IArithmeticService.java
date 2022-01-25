package org.miltondevs.maven.miltondevscalculus.service;

import java.util.List;

/**
 * Arithmetic service interface.
 * 
 * Definition of the arithmetic operations provided by this microservice.
 * 
 * @author Mario Benito Rodriguez
 *
 */
public interface IArithmeticService {

	/**
	 * Method for getting the addition of a list of float values.
	 * 
	 * @param parameters List of float values (expecting float always)
	 * @return The sum of values
	 */
	float additionOperation(List<Float> parameters);
	
	/**
	 * Method for getting the subtraction of a list of float values.
	 * 
	 * @param parameters List of float values (expecting float always)
	 * @return The subtraction of values
	 */
	float subtractOperation(List<Float> parameters);
}
