package com.sunruyi.stupid.trader.application;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ios on 16/5/13.
 */
public class ATest {

    @Test
    public void testEnv() {
        assertThat("ok", is("ok"));
    }
}
