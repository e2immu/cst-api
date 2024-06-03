package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.type.ParameterizedType;

import java.util.List;

public interface ConstructorCall extends Expression {
    MethodInfo constructor();

    List<Expression> parameterExpressions();

    TypeInfo anonymousClass();

    ParameterizedType parameterizedType();

    ConstructorCall withParameterExpressions(List<Expression> newParameterExpressions);
}
