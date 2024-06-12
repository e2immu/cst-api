package org.e2immu.cstapi.statement;

public interface ContinueStatement extends BreakOrContinueStatement {
    interface Builder extends Statement.Builder<ContinueStatement.Builder> {
        ContinueStatement build();
    }
}
