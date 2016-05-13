package com.sunruyi.stupid.trader;

import java.math.BigDecimal;

/**
 * Created by ios on 16/5/13.
 */
public class Price {

    private final BigDecimal value;

    public Price(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal value() {
        return value;
    }

    public boolean lessThan(Price price) {
        return this.value.compareTo(price.value) < 0;
    }
}
