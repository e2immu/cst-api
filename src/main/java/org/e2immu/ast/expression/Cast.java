package org.e2immu.ast.expression;

import org.e2immu.ast.type.ParameterizedType;

public interface Cast extends Expression {
    Expression getExpression();

    ParameterizedType getParameterizedType();
}
