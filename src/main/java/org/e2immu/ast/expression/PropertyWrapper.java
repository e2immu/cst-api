package org.e2immu.ast.expression;

import org.e2immu.ast.type.ParameterizedType;

public interface PropertyWrapper extends Expression {
    ParameterizedType castType();

    Expression getExpression();
}
