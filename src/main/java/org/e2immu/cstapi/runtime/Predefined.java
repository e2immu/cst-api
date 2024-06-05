package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.AnnotationExpression;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.type.ParameterizedType;

public interface Predefined extends PredefinedWithoutParameterizedType {
    ParameterizedType intParameterizedType();

    ParameterizedType booleanParameterizedType();

    ParameterizedType boxedBooleanParameterizedType();

    ParameterizedType longParameterizedType();

    ParameterizedType doubleParameterizedType();

    ParameterizedType floatParameterizedType();

    ParameterizedType shortParameterizedType();

    ParameterizedType charParameterizedType();

    ParameterizedType widestType(ParameterizedType t1, ParameterizedType t2);

    /*
    used by binaryOperator, the result cannot be null, so must be the unboxed version (this contrasts with
    ParameterizedType.commonType)
     */
    ParameterizedType widestTypeUnbox(ParameterizedType t1, ParameterizedType t2);


}
