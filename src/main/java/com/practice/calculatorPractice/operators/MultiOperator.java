package com.practice.calculatorPractice.operators;

import com.practice.calculatorPractice.NewArithmeticInterface;

public class MultiOperator implements NewArithmeticInterface {
	@Override
	public boolean supports(String operator) {
		return "*".equals(operator);
	}

	@Override
	public int calculate(PositiveValidation operand1, PositiveValidation operand2) {
		return operand1.toInt() * operand2.toInt();
	}
}
