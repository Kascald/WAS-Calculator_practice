package com.practice.calculatorPractice.operators;

public class PositiveValidation {
	private final int value;

	public PositiveValidation(int value) {
		validate(value);
		this.value = value;
	}

	private void validate(int value) {
		if(isNegativeValue(value))
			throw new IllegalArgumentException("0 또는 음수를 전달하려고 합니다.");
		
	}

	private boolean isNegativeValue(int value) {
		return value <= 0;
	}

	public int toInt() {
		return value;
	}
}
