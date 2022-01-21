package org.miltondevs.maven.miltondevscalculus.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticService implements IArithmeticService {

	@Override
	public float summaryOperation(List<Float> parameters) {
		return parameters.stream().reduce((float) 0, (acumulator, element) -> acumulator + element);
	}

	@Override
	public float substractOperation(List<Float> parameters) {
		float firstParameter = parameters.remove(0);
		return parameters.stream().reduce(firstParameter, (acumulator, element) -> acumulator - element);
	}
	
}
