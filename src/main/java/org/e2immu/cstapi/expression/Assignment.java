package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.variable.Variable;

public interface Assignment extends Expression {
    Expression target();
    Expression value();

    Variable variableTarget();

    MethodInfo assignmentOperator();

    Boolean prefixPrimitiveOperator();

    MethodInfo binaryOperator();
}
