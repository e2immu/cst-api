package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.info.MethodInfo;

public interface BinaryOperator extends Expression {

    Expression lhs();
    Expression rhs();

    MethodInfo operator();

    Precedence precedence();
}
