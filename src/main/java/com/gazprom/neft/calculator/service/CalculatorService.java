package com.gazprom.neft.calculator.service;

import com.gazprom.neft.calculator.gateway.CalculatorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final CalculatorClient calculatorClient;

    public int add(int firstSlogan, int secondSlogan) {
        return calculatorClient.add(firstSlogan, secondSlogan).getAddResult();
    }

    public int subtract(int minuend, int subtrahend) {
        return calculatorClient.subtract(minuend, subtrahend).getSubtractResult();
    }

    public int multiply(int firstFactor, int secondFactor) {
        return calculatorClient.multiply(firstFactor, secondFactor).getMultiplyResult();
    }

    public int divide(int dividend, int divider) {
        return calculatorClient.divide(dividend, divider).getDivideResult();
    }
}
