package org.e2immu.ast.expression;

import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.type.ParameterizedType;

import java.util.List;

public interface ConstructorCall extends Expression {
    MethodInfo constructor();

    MethodInfo getMethodInfo();

    List<Expression> parameterExpressions();

    TypeInfo anonymousClass();

    ConstructorCall copy(List<Expression> newParameterExpressions);
    ConstructorCall copy(Identifier identifier);

    ParameterizedType parameterizedType();
}
