package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.Price;
import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Pass;
import com.sunruyi.stupid.trader.operation.Sell;

/**
 * Created by ios on 16/5/14.
 */
public class Calculator {

    private Price[] prices;

    public Calculator(Price... prices) {
        this.prices = prices;
    }

    public Transactions invoke() {
        PriceSequence priceSequence = new PriceSequence(prices);
        if (priceSequence.isRaiseUpTrend()) {
            return new Transactions(new Buy(), new Pass(), new Pass(), new Pass(), new Sell());
        } else {
            return new Transactions(new Pass(), new Pass(), new Pass(), new Pass(), new Pass());
        }
    }
}
