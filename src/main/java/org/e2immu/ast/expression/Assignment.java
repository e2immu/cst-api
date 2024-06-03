package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.variable.Variable;

public interface Assignment extends Expression {
    Expression target();
    Expression value();

    Variable variableTarget();

    MethodInfo assignmentOperator();

    Boolean prefixPrimitiveOperator();

    MethodInfo binaryOperator();
}
