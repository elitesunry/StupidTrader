package com.sunruyi.stupid.trader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ios on 16/5/13.
 */
public class PriceSequence {

    private List<Price> prices;

    public PriceSequence(Price... prices) {
        this.prices = Arrays.asList(prices);
    }

    public boolean isRaiseUpTrend() {
        return prices.get(0).lessThan(prices.get(prices.size() - 1));
    }
}
