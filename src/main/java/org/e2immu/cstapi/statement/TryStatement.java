package org.e2immu.cstapi.statement;

import org.e2immu.cstapi.expression.CatchParameter;
import org.e2immu.cstapi.expression.Expression;

import java.util.List;

public interface TryStatement extends Statement {

    interface CatchClause {
        CatchParameter catchParameter();

        Block block();
    }

    Block finallyBlock();

    List<CatchClause> catchClauses();

    List<Expression> resources();
}
