package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.type.ParameterizedType;

public interface MethodReference extends Expression {
    Expression scope();

    ParameterizedType concreteReturnType();

    MethodInfo methodInfo();
}
