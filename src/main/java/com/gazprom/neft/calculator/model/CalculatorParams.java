package com.gazprom.neft.calculator.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CalculatorParams {

    @NotNull
    private Integer intA;

    @NotNull
    private Integer intB;
}
