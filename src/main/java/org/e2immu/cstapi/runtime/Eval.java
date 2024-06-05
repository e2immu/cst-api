package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.Expression;

import java.util.List;

public interface Eval {

    Expression product(Expression lhs, Expression rhs);

    Expression sum(Expression lhs, Expression rhs);

    Expression negate(Expression expression);

    Expression negate(Expression expression, boolean allowEqualsToEvaluate);

    Expression remainder(Expression lhs, Expression rhs);

    Expression equals(Expression lhs, Expression rhs);

    Expression equals(boolean allowEqualsToEvaluate, Expression lhs, Expression rhs);

    // FIXME rename

    Expression newOr(List<Expression> expressions);

    Expression newOr(Expression... expressions);

    Expression newAnd(Expression... expressions);

    Expression newAnd(List<Expression> expressions);

    Expression newAnd(boolean allowEqualsToEvaluate, List<Expression> expressions);

    Expression newOr(boolean allowEqualsToEvaluate, Expression... expressions);

}
