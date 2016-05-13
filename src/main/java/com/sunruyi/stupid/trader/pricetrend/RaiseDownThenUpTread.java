package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.Price;
import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Sell;

/**
 * Created by ios on 16/5/14.
 */
public class RaiseDownThenUpTread extends Trend {

    public RaiseDownThenUpTread(PriceSequence priceSequence) {
        super(priceSequence);
    }

    @Override
    public Transactions transactions() {
        Price smallestPrice = priceSequence.smallestPrice();
        smallestPrice.setOperation(new Buy());
        Price lastPrice = priceSequence.lastPrice();
        lastPrice.setOperation(new Sell());

        return toTransaction(priceSequence.operations());
    }
}
