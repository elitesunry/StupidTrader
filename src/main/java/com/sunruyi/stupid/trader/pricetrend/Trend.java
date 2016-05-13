package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Operation;

import java.util.List;

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

    protected Transactions toTransaction(List<Operation> operations) {
        Transactions transactions = new Transactions(operations.toArray(new Operation[operations.size()]));
        return transactions;
    }
}
