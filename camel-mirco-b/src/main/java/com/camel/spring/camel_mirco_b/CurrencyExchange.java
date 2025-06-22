package com.camel.spring.camel_mirco_b;

import java.math.BigDecimal;

public class CurrencyExchange {
    Long id;
    String from;
    String to;
    BigDecimal conversionMultiple;

    public CurrencyExchange() {}

    public CurrencyExchange(String to, Long id, String from, BigDecimal conversionMultiple) {
        super();
        this.to = to;
        this.id = id;
        this.from = from;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }


}
