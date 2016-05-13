package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.operation.Operation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ios on 16/5/13.
 */
public class Transactions {

    private List<Operation> operations;

    public Transactions(Operation ... operations) {
         this.operations = Arrays.asList(operations);
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size(); i++) {
            builder.append(operations.get(i).code() + (isLastOperation(i) ? "" :","));
        }
        builder.append("]");
        return builder.toString();
    }

    private boolean isLastOperation(int i) {
        return i == operations.size() -1;
    }

    private int size() {
        return operations.size();
    }
}
