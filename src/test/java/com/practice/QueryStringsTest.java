package com.practice;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueryStringsTest {

	@Test
	void createStringsTest() {

	QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

	assertThat(queryStrings).isNotNull();
	}
}