package com.camel.spring.camel_mirco_b.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .to("log:receive-message-from-activemq");
    }
}
