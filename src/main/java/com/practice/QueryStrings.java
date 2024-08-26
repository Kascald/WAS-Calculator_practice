package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {

	private List<QueryString> queryStrings = new ArrayList<>();

	public QueryStrings(String stringsLines) {
		String[] queryStringsTokens = stringsLines.split("&");
		Arrays.stream(queryStringsTokens)
				.forEach(queryString-> {
					String[] values = queryString.split("=");
					if (values.length != 2) {
						throw new IllegalArgumentException("Invalid query string");
					}

					queryStrings.add(new QueryString(values[0],values[1]));
				});
	}

	public String getValue(String key) {
		return this.queryStrings.stream()
				.filter(queryString -> queryString.exists(key))
				.map(QueryString::getValue)
				.findFirst()
				.orElse(null);
	}
}
