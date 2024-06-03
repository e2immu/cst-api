package org.e2immu.ast.runtime;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.type.ParameterizedType;

public interface Predefined extends PredefinedWithoutParameterizedType {
    ParameterizedType intParameterizedType();

    ParameterizedType booleanParameterizedType();

    ParameterizedType objectParameterizedType();

    ParameterizedType voidParameterizedType();

    ParameterizedType stringParameterizedType();

    MethodInfo assignOperator(ParameterizedType parameterizedType);
}
