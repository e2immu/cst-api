package org.e2immu.cstapi.statement;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.expression.Expression;

public interface WhileStatement extends LoopStatement {
    Expression expression();

    interface Builder extends Statement.Builder<WhileStatement.Builder> {
        @Fluent
        WhileStatement.Builder setExpression(Expression expression);

        @Fluent
        WhileStatement.Builder setBlock(Block block);

        WhileStatement build();
    }
}
