package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Operation;

import java.util.List;

/**
 * Created by ios on 16/5/14.
 */
public class RaiseDownTread extends Trend {

    public RaiseDownTread(PriceSequence priceSequence) {
        super(priceSequence);
    }

    @Override
    public Transactions transactions() {
        List<Operation> operations = priceSequence.operations();
        return toTransaction(operations);
    }
}
