package com.sunruyi.stupid.trader.application;

import com.sunruyi.stupid.trader.Price;
import com.sunruyi.stupid.trader.PriceSequence;
import com.sunruyi.stupid.trader.Transactions;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Pass;
import com.sunruyi.stupid.trader.operation.Sell;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ios on 16/5/13.
 */
public class ApplicationTest {

    /**
     * when prices sequence like this:
     *
     *           *
     *         *
     *       *
     *     *
     *   *
     *
     */
    @Test
    public void should_buy_at_start_sell_at_end() {
        Price[] prices = {new Price("1"), new Price("2"), new Price("3"), new Price("4"), new Price("5")};
        Transactions transactions = calculate(prices);
        assertThat(transactions.print(), is("[Buy,Pass,Pass,Pass,Sell]"));
    }

    /**
     * when prices sequence like this:
     *
     *   *
     *     *
     *       *
     *         *
     *           *
     *
     */
    @Test
    public void should_pass_all_the_day() {
        Price[] prices = {new Price("5"), new Price("4"), new Price("3"), new Price("2"), new Price("1")};
        Transactions transactions = calculate(prices);
        assertThat(transactions.print(), is("[Pass,Pass,Pass,Pass,Pass]"));
    }

    private Transactions calculate(Price[] prices) {
        PriceSequence priceSequence = new PriceSequence(prices);
        return new Transactions(new Buy(), new Pass(), new Pass(), new Pass(), new Sell());
    }

    /**
     * when prices sequence like this:
     *
     *       *
     *     *   *
     *   *       *
     *
     */
    @Test
    public void should_buy_at_start_sell_at_top() {
    }

    /**
     * when prices sequence like this:
     *
     *   *       *
     *     *   *
     *       *
     *
     */
    @Test
    public void should_buy_at_bottom_sell_at_end() {
    }
}
