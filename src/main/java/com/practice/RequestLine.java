package com.practice;

import java.util.Objects;

public class RequestLine {


	private final String method;
	private final String urlPath;
	private QueryStrings queryStrings;

	public RequestLine(String requestLine) {
		String[] tokens = requestLine.split(" ");
		this.method = tokens[0];

		String[] urlPathTokens = tokens[1].split("\\?");
		this.urlPath = urlPathTokens[0];

		if(urlPathTokens.length == 2) {
			this.queryStrings = new QueryStrings(urlPathTokens[1]);
		}


	}

	public RequestLine(String method, String urlPaths, String queryString) {
		this.method = method;
		this.urlPath = urlPaths;
		this.queryStrings = new QueryStrings(queryString);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RequestLine that)) return false;
		return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, urlPath, queryStrings);
	}

	public boolean isGetRequest() {
		return "GET".equals(this.method);
	}

	public boolean isMatchPath(String requestPath) {
		return urlPath.equals(requestPath);
	}

	public QueryStrings getQueryString() {
		return queryStrings;
	}
}
