package com.sunruyi.stupid.trader;

import com.sunruyi.stupid.trader.operation.Operation;
import com.sunruyi.stupid.trader.operation.Pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ios on 16/5/13.
 */
public class Transactions {

    private List<Operation> operations;

    public static Transactions DEFAULT_TRANSACTION(int operationCount) {
        return new Transactions(operationCount);
    }

    public Transactions(Operation ... operations) {
         this.operations = Arrays.asList(operations);
    }

    private Transactions(int operationCount) {
        List<Operation> operations = new ArrayList<Operation>(operationCount);
        for (int i = 0; i < operationCount; i++) {
            operations.add(new Pass());
        }
        this.operations = operations;
    }

    public String operations() {
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
