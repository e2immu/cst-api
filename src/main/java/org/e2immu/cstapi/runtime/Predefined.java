package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.type.ParameterizedType;

public interface Predefined extends PredefinedWithoutParameterizedType {
    ParameterizedType intParameterizedType();

    ParameterizedType booleanParameterizedType();

    ParameterizedType objectParameterizedType();

    ParameterizedType voidParameterizedType();

    ParameterizedType stringParameterizedType();

    MethodInfo assignOperator(ParameterizedType parameterizedType);
}
