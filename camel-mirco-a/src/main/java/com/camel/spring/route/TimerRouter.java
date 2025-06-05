package com.camel.spring.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRouter extends RouteBuilder {
    public void configure() throws Exception {
        from("timer:first-timer")
                .transform().constant("My constant value")
                .to("log:timer:second-timer");
    }
}
