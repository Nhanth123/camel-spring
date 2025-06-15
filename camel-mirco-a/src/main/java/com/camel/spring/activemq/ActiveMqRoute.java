package com.camel.spring.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //timer
//from("activemq:queue:queue?period=10000")
//                .transform().constant("My message for activemq")
//                .to("activemq:queue:queue");

    from("file:files/json")
            .transform().constant("My message for Active")
            .log("{body}")
            .to("activemq:my-activemq-queue");

    }
}
