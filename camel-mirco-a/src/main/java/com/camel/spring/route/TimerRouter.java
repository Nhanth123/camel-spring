package com.camel.spring.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class TimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggerProcessingComponent loggerComponent;

    @Override
    public void configure() throws Exception {
        from("timer:first-timer")
                //.transform().constant("Time now:" + LocalDateTime.now())
                .bean(getCurrentTimeBean)
                .to("log:timer:second-timer");
    }
}

@Component
class GetCurrentTimeTimeBean {
    public String getCurrentTime() {
        return "Time now: " + LocalDateTime.now();
    }
}

@Component
class SimpleLoggerProcessingComponent {
    private Logger logger = LoggerFactory.getLogger(SimpleLoggerProcessingComponent.class);
    public void process(String message) {
        logger.info("Simple logging message {}", message);
    }
}