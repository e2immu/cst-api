package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.type.ParameterizedType;

public interface Lambda extends Expression {
    ParameterizedType abstractFunctionalType();

    MethodInfo methodInfo();

    ParameterizedType concreteReturnType();

    enum OutputVariant {
        EMPTY
    }
}
