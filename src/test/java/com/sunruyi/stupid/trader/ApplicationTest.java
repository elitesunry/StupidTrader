package com.sunruyi.stupid.trader;

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
        Transactions transactions = new StupidTrader(prices).plan();
        assertThat(transactions.operations(), is("[Buy,Pass,Pass,Pass,Sell]"));
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
        Transactions transactions = new StupidTrader(prices).plan();
        assertThat(transactions.operations(), is("[Pass,Pass,Pass,Pass,Pass]"));
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
        Price[] prices = {new Price("1"), new Price("2"), new Price("3"), new Price("2"), new Price("1")};
        Transactions transactions = new StupidTrader(prices).plan();
        assertThat(transactions.operations(), is("[Buy,Pass,Sell,Pass,Pass]"));
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
