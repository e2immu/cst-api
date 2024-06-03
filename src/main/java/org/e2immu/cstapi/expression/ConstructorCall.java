package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.type.ParameterizedType;

import java.util.List;

public interface ConstructorCall extends Expression {
    MethodInfo constructor();

    List<Expression> parameterExpressions();

    TypeInfo anonymousClass();

    ParameterizedType parameterizedType();

    ConstructorCall withParameterExpressions(List<Expression> newParameterExpressions);
}
