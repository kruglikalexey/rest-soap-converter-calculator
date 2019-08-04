package com.gazprom.neft.calculator.config;

import com.gazprom.neft.calculator.gateway.CalculatorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@RequiredArgsConstructor
public class SoapWSCalculatorConfig {
	private final SoapWSCalculatorProperties calculatorProperties;
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(calculatorProperties.getContextPath());
		return marshaller;
	}
	
	@Bean
	public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
		CalculatorClient client = new CalculatorClient(calculatorProperties);
		client.setDefaultUri(calculatorProperties.getUri());
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
