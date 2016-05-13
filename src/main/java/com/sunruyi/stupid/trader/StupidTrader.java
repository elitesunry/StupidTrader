package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.pricetrend.Trend;

/**
 * Created by ios on 16/5/14.
 */
public class StupidTrader {

    private Price[] prices;

    public StupidTrader(Price... prices) {
        this.prices = prices;
    }

    public Transactions plan() {
        Trend trend = new PriceSequence(prices).trend();
        Transactions transactions = trend.transactions();
        return transactions;
    }
}
