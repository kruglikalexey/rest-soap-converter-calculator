package com.gazprom.neft.calculator.util;

public class DivideValidator {
    public static void validateDevider(int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException("Divider can't be zero value");
        }
    }
}
