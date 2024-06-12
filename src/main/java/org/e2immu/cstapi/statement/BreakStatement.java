package org.e2immu.cstapi.statement;

public interface BreakStatement extends BreakOrContinueStatement {

    interface Builder extends Statement.Builder<Builder> {
        BreakStatement build();
    }

}
