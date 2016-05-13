package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.operation.Pass;
import com.sunruyi.stupid.trader.operation.Sell;

import java.math.BigDecimal;

/**
 * Created by ios on 16/5/13.
 */
public class Price {

    private final BigDecimal value;
    private Operation operation;

    public Price(String value) {
        this.value = new BigDecimal(value);
        this.operation = new Pass();
    }

    public BigDecimal value() {
        return value;
    }


    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Operation operation() {
        return operation;
    }

    public boolean lessThan(Price price) {
        return this.value.compareTo(price.value) < 0;
    }

    public boolean biggerThan(Price price) {
        return this.value.compareTo(price.value) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return !(value != null ? !value.equals(price.value) : price.value != null);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
