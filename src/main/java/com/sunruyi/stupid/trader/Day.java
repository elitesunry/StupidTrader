package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.operation.Pass;

/**
 * Created by ios on 16/5/13.
 */
public class Day {

    private Price price;
    private Operation operation;

    public Day(Price price, Operation operation) {
        this.price = price;
        this.operation = operation;
    }

    public Day(Price price) {
        this(price, new Pass());
    }

    public Operation operation() {
        return this.operation;
    }
}
