package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.runtime.EvaluationResult;

public interface GreaterThanZero extends Expression {
    Expression expression();

    boolean allowEquals();

    XB extract(EvaluationResult e);

    interface XB {
        Expression x();
        double b();
        boolean lessThan();
    }
}
