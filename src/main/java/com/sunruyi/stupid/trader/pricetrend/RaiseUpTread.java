package com.sunruyi.stupid.trader.pricetrend;

import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Pass;
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
        return new Transactions(new Buy(), new Pass(), new Pass(), new Pass(), new Sell());
    }
}
