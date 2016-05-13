package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.pricetrend.*;

import java.util.ArrayList;
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

    public Price lastPrice() {
        return prices.get(size() - 1);
    }

    public Price firstPrice() {
        return prices.get(0);
    }

    public Price biggestPrice() {
        Price theBiggest = firstPrice();
        for (Price price : prices) {
            if(price.biggerThan(theBiggest)) {
                theBiggest = price;
            }
        }
        return theBiggest;
    }

    public Price smallestPrice() {
        Price theSmallest = firstPrice();
        for (Price price : prices) {
            if(price.lessThan(theSmallest)) {
                theSmallest = price;
            }
        }
        return theSmallest;
    }

    public Trend trend() {
        if(isRaiseUpTrend()) {
            return new RaiseUpTread(this);
        } else if(isRaiseDownTrend()){
            return new RaiseDownTread(this);
        } else if(isRaiseUpThenDownTrend()){
            return new RaiseUpThenDownTread(this);
        } else if(isRaiseDownThenUpTrend()){
            return new RaiseDownThenUpTread(this);
        } else {
            throw new IllegalStateException("Trader can not make a trade plan.");
        }
    }

    private boolean isRaiseUpTrend() {
        for (int i = 0; i < size()-1; i++) {
            Price currentPrice = prices.get(i);
            Price nextPrice = prices.get(i + 1);
            if(nextPrice.lessThan(currentPrice)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRaiseDownTrend() {
        for (int i = 0; i < size()-1; i++) {
            Price currentPrice = prices.get(i);
            Price nextPrice = prices.get(i + 1);
            if(nextPrice.biggerThan(currentPrice)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRaiseUpThenDownTrend() {
        Price theBiggest = biggestPrice();
        if(theBiggest.biggerThan(firstPrice()) && theBiggest.biggerThan(lastPrice())) {
            return true;
        }
        return false;
    }

    private boolean isRaiseDownThenUpTrend() {
        Price theSmallest = smallestPrice();
        if(theSmallest.lessThan(firstPrice()) && theSmallest.lessThan(lastPrice())) {
            return true;
        }
        return false;
    }

    public int size() {
        return prices.size();
    }

    public List<Operation> operations() {
        List<Operation> operations = new ArrayList<Operation>(size());
        for (Price price : prices) {
            operations.add(price.operation());
        }
        return operations;
    }
}
