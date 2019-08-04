package com.gazprom.neft.calculator.controller;

import com.gazprom.neft.calculator.model.CalculatorParams;
import com.gazprom.neft.calculator.service.CalculatorService;
import com.gazprom.neft.calculator.util.DivideValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "RestCalculatorController", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RestController
@RequiredArgsConstructor
public class RestCalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/add")
    public int add(@Valid @RequestBody CalculatorParams params) {
        return calculatorService.add(params.getIntA(), params.getIntB());
    }

    @PostMapping("/subtract")
    public int subtract(@Valid @RequestBody CalculatorParams params) {
        return calculatorService.subtract(params.getIntA(), params.getIntB());
    }

    @PostMapping("/multiply")
    public int multiply(@Valid @RequestBody CalculatorParams params) {
        return calculatorService.multiply(params.getIntA(), params.getIntB());
    }

    @PostMapping("/divide")
    public int divide(@Valid @RequestBody CalculatorParams params) {
        DivideValidator.validateDevider(params.getIntB());

        return calculatorService.divide(params.getIntA(), params.getIntB());
    }
}
