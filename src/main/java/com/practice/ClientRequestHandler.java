package com.practice;

import com.practice.calculatorPractice.Calculator;
import com.practice.calculatorPractice.operators.PositiveValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);

	private final Socket clientSocket;

	public ClientRequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		logger.info("{ClientRequestHandler} new client {} started",Thread.currentThread().getName());

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

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
