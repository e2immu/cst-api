package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.type.ParameterizedType;

public interface Cast extends Expression {
    Expression getExpression();

    ParameterizedType getParameterizedType();
}
