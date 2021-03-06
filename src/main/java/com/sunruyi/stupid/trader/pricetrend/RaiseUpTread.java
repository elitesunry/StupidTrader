package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.Price;
import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Sell;

/**
 * Created by ios on 16/5/14.
 */
public class RaiseUpTread extends Trend {

    public RaiseUpTread(PriceSequence priceSequence) {
        super(priceSequence);
    }

    @Override
    public Transactions transactions() {
        Price firstPrice = priceSequence.firstPrice();
        firstPrice.setOperation(new Buy());
        Price lastPrice = priceSequence.lastPrice();
        lastPrice.setOperation(new Sell());

        return toTransaction(priceSequence.operations());
    }
}
