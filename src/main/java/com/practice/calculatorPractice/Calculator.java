package com.practice.calculatorPractice;


import com.practice.calculatorPractice.operators.*;

import java.util.List;

public class Calculator {
	private static final List<NewArithmeticInterface> arithmeticOperators = List.of(new AddOperator(), new SubOperator() , new MultiOperator() , new DivOperator());

	public static int calculate(PositiveValidation operand1 , String operator, PositiveValidation operand2) {
		return arithmeticOperators.stream()
				.filter(arithmeticOperators -> arithmeticOperators.supports(operator))
				.map(arithmeticOperators -> arithmeticOperators.calculate(operand1,operand2))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산을 다시 실행해주세요"));

		//return ArithmeticOperator.calculate(operand1, operator, operand2);
	}
}
