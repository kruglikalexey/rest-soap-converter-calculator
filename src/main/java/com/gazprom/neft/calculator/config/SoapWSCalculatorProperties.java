package com.gazprom.neft.calculator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("ws.calculator")
public class SoapWSCalculatorProperties {
    private String uri;
    private String contextPath;
    private Callback callback;

    @Data
    public static class Callback {
        private String endpoint;
        private Action action;
    }

    @Data
    public static class Action {
        private String add;
        private String subtract;
        private String multiply;
        private String divide;
    }
}
