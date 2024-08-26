package com.practice.calculatorPractice.operators;

import com.practice.calculatorPractice.NewArithmeticInterface;

public class DivOperator implements NewArithmeticInterface {
	@Override
	public boolean supports(String operator) {
		return "/".equals(operator);
	}

	@Override
	public int calculate(PositiveValidation operand1, PositiveValidation operand2) {
//		if( operand2 == 0)
//			throw new IllegalArgumentException("나누기 0 오류");
		return operand1.toInt() / operand2.toInt();
	}
}
