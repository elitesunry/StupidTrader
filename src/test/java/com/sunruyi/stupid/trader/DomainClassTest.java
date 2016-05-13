package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.*;
import com.sunruyi.stupid.trader.operation.Buy;
import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.operation.Pass;
import com.sunruyi.stupid.trader.operation.Sell;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

/**
 * Created by ios on 16/5/13.
 */
public class DomainClassTest {

    @Test
    public void there_should_have_a_price() {
        String value = "1";
        assertThat(new Price(value), isA(Price.class));
        assertThat(new Price(value).value(), is(new BigDecimal(value)));
    }

    @Test
    public void there_should_have_a_transaction() {
        assertThat(new Transactions(), isA(Transactions.class));
    }

    @Test
    public void there_should_have_a_operation() {
        assertThat(new Operation(), isA(Operation.class));
    }

    @Test
    public void operation_may_be_buy() {
        assertThat(new Buy(), isA(Operation.class));
    }

    @Test
    public void operation_may_be_sell() {
        assertThat(new Sell(), isA(Operation.class));
    }

    @Test
    public void operation_may_be_pass() {
        assertThat(new Pass(), isA(Operation.class));
    }

    @Test
    public void transaction_should_has_a_operation_sequence() {
        assertThat(new Transactions(new Buy(), new Sell(), new Pass()).operations(), is("[Buy,Sell,Pass]"));
    }

    @Test
    public void one_day_has_a_price_a_operation() {
        assertThat(new Day(new Price("3"), new Operation()), isA(Day.class));
    }

    @Test
    public void one_day_has_a_price_and_its_operation_default_is_pass() {
        Day actual = new Day(new Price("3"));
        assertThat(actual.operation().code(), is(new Pass().code()));
    }

    @Test
    public void there_should_have_a_price_sequence() {
        assertThat(new PriceSequence(new Price("1"), new Price("2"), new Price("3")), isA(PriceSequence.class));
    }
}
