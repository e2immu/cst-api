package org.e2immu.ast.expression;

import org.e2immu.ast.type.ParameterizedType;
import org.e2immu.ast.variable.LocalVariable;

public interface InstanceOf extends Expression {
    Expression expression();

    LocalVariable patternVariable();

    ParameterizedType parameterizedType();
}
