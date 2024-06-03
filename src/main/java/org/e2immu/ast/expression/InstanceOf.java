package org.e2immu.ast.expression;

import org.e2immu.ast.type.ParameterizedType;
import org.e2immu.ast.variable.LocalVariableReference;

public interface InstanceOf extends Expression {
    Expression expression();

    LocalVariableReference patternVariable();

    ParameterizedType parameterizedType();
}
