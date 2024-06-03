package org.e2immu.ast.statement;

import org.e2immu.ast.expression.CatchParameter;
import org.e2immu.ast.expression.Expression;

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
