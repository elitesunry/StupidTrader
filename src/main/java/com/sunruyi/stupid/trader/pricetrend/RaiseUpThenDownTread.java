package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.Price;
import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.operation.Sell;

import java.util.List;

/**
 * Created by ios on 16/5/14.
 */
public class RaiseUpThenDownTread extends Trend {

    public RaiseUpThenDownTread(PriceSequence priceSequence) {
        super(priceSequence);
    }

    @Override
    public Transactions transactions() {
        Price biggestPrice = priceSequence.biggestPrice();
        biggestPrice.setOperation(new Sell());
        Price firstPrice = priceSequence.firstPrice();
        firstPrice.setOperation(new Buy());

        List<Operation> operations = priceSequence.operations();
        return toTransaction(operations);
    }
}
