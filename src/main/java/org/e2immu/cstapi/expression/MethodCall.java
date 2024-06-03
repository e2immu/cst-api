package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.expression.util.OneVariable;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.type.ParameterizedType;

import java.util.List;

public interface MethodCall extends Expression, OneVariable {
    MethodInfo methodInfo();

    Expression object();

    List<Expression> parameterExpressions();

    String modificationTimes();

    boolean objectIsImplicit();

    ParameterizedType concreteReturnType();
}
