package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.type.ParameterizedType;

public interface Lambda extends Expression {
    ParameterizedType abstractFunctionalType();

    MethodInfo methodInfo();

    ParameterizedType concreteReturnType();

    enum OutputVariant {
        EMPTY
    }
}
