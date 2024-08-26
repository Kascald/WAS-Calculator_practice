package com.practice.calculatorPractice;

import com.practice.calculatorPractice.operators.PositiveValidation;

public interface NewArithmeticInterface {
	boolean supports(String operator);
	int calculate(PositiveValidation operand1, PositiveValidation operand2);
}
