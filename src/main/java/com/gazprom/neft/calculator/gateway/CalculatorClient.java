package com.gazprom.neft.calculator.gateway;

import com.gazprom.neft.calculator.config.SoapWSCalculatorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;
import calculator.wsdl.Divide;
import calculator.wsdl.DivideResponse;
import calculator.wsdl.Multiply;
import calculator.wsdl.MultiplyResponse;
import calculator.wsdl.Subtract;
import calculator.wsdl.SubtractResponse;

@Service
@RequiredArgsConstructor
public class CalculatorClient extends WebServiceGatewaySupport {
	private final SoapWSCalculatorProperties properties;

	public AddResponse add(int firstSlogan, int secondSlogan) {
		final String addActionEndpoint = properties.getCallback().getEndpoint() +
								  		 properties.getCallback().getAction().getAdd();

		final Add request = new Add();
		request.setIntA(firstSlogan);
		request.setIntB(secondSlogan);

		return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(properties.getUri(),
																		   request,
																		   new SoapActionCallback(addActionEndpoint));
	}

	public SubtractResponse subtract(int minuend, int subtrahend) {
		final String subtractActionEndpoint = properties.getCallback().getEndpoint() +
				properties.getCallback().getAction().getSubtract();

		final Subtract request = new Subtract();
		request.setIntA(minuend);
		request.setIntB(subtrahend);

		return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(
																	properties.getUri(),
																	request,
																	new SoapActionCallback(subtractActionEndpoint));
	}

	public MultiplyResponse multiply(int firstFactor, int secondFactor) {
		final String multiplyActionEndpoint = properties.getCallback().getEndpoint() +
											  properties.getCallback().getAction().getMultiply();

		final Multiply request = new Multiply();
		request.setIntA(firstFactor);
		request.setIntB(secondFactor);

		return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
																	properties.getUri(),
																	request,
																	new SoapActionCallback(multiplyActionEndpoint));
	}

	public DivideResponse divide(int dividend, int divider) {
		final String divideActionEndpoint = properties.getCallback().getEndpoint() +
											properties.getCallback().getAction().getDivide();

		final Divide request = new Divide();
		request.setIntA(dividend);
		request.setIntB(divider);

		return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(
																	properties.getUri(),
																	request,
																	new SoapActionCallback(divideActionEndpoint));
	}

}

