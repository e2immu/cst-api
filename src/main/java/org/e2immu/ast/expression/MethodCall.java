package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.type.ParameterizedType;

import java.util.List;

public interface MethodCall extends Expression {
    MethodInfo methodInfo();

    Expression object();

    List<Expression> parameterExpressions();

    String modificationTimes();

    boolean objectIsImplicit();

    ParameterizedType concreteReturnType();
}
