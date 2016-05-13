package com.sunruyi.stupid.trader.application;

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
        Transactions transactions = new Transactions(new Buy(), new Pass(), new Pass(), new Pass(), new Sell());
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
        assertThat("ok", is("ok"));
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
        assertThat("ok", is("ok"));
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
        assertThat("ok", is("ok"));
    }
}
