package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Pass;
import com.sunruyi.stupid.trader.operation.Sell;

import java.util.Collections;

/**
 * Created by ios on 16/5/14.
 */
public class Trend {

    protected PriceSequence priceSequence;

    public Trend(PriceSequence priceSequence) {
        this.priceSequence = priceSequence;
    }

    public Transactions transactions() {
        throw new IllegalArgumentException("invalid call on tread");
    }
}
