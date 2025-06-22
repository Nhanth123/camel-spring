package com.camel.spring.camel_mirco_b.routes;

import com.camel.spring.camel_mirco_b.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Autowired
    private MyCurrencyExchangeProcessor MyCurrencyExchangeProcessor;

    @Autowired
    private MyCurrencyExchangeTransformer MyCurrencyExchangeTransformer;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(MyCurrencyExchangeProcessor)
                .bean(MyCurrencyExchangeTransformer)
                .to("log:receive-message-from-activemq");
    }
}

@Component
class MyCurrencyExchangeProcessor {
    Logger logger  = LoggerFactory.getLogger(ActiveMqReceiverRouter.class);
    public void processMessage(CurrencyExchange exchange) {
        logger.info("Processing exchange:" , exchange);
    }
}

@Component
class MyCurrencyExchangeTransformer {
    public CurrencyExchange processMessage(CurrencyExchange exchange) {
        exchange.setConversionMultiple(exchange.getConversionMultiple().multiply(BigDecimal.TEN));
        return exchange;
    }
}