package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;

public interface BinaryOperator extends Expression {

    Expression lhs();
    Expression rhs();

    MethodInfo operator();

    Precedence precedence();
}
