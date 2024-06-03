package org.e2immu.ast.expression;

import org.e2immu.ast.type.ParameterizedType;

public interface TypeExpression extends Expression {
    ParameterizedType parameterizedType();
}
