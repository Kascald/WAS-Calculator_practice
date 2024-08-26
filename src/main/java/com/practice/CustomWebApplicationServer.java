package com.practice;


import com.practice.calculatorPractice.Calculator;
import com.practice.calculatorPractice.operators.PositiveValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {

	private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
	public CustomWebApplicationServer(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			logger.info("{CustomWebApplicationServer} started {} port.",port);

			Socket clientSocket;
			logger.info("{CustomWebApplicationServer} waiting for clinet");

			while((clientSocket = serverSocket.accept())  != null) {
				logger.info("{CustomWebApplicationServer} client connected!");

				try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
					DataOutputStream dos = new DataOutputStream(out);
//
//					String line;
//					while((line = reader.readLine()) != "") {
//						System.out.println(line);
//					}

					HttpRequest httpRequest = new HttpRequest(reader);
					//GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1

					if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
						QueryStrings queryStrings = httpRequest.getQueryStrings();

						int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
						String operator = queryStrings.getValue("operator");
						int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

						int calculated = Calculator.calculate(new PositiveValidation(operand1), operator , new PositiveValidation(operand2));
						byte[] body = String.valueOf(calculated).getBytes();

						HttpResponse response = new HttpResponse(dos);
						response.response200Header("application/json", body.length);
						response.responseBody(body);
					}

				}
			}
		}

	}
}
