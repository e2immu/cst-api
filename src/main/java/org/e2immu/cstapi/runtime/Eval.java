package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.Expression;

import java.util.List;

public interface Eval {

    Expression product(Expression lhs, Expression rhs);

    Expression sum(Expression lhs, Expression rhs);

    Expression negate(Expression expression);

    Expression remainder(Expression lhs, Expression rhs);

    Expression equals(Expression lhs, Expression rhs);


    Expression greater(Expression lhs, Expression rhs, boolean allowEquals);

    Expression or(List<Expression> expressions);

    Expression or(Expression... expressions);

    Expression and(Expression... expressions);

    Expression and(List<Expression> expressions);

    boolean isNotNull0(Expression expression);

    int limitOnComplexity();
}
