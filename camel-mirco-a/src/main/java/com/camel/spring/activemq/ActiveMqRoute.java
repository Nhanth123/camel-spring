package com.camel.spring.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //timer
        from("activemq:queue:queue?period=10000")
                .transform().constant("My message for activemq")
                .to("activemq:queue:queue");
    }
}
