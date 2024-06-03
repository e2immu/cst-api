package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;

public interface UnaryOperator extends Expression {
    Expression expression();

    MethodInfo operator();

    Precedence precedence();
}
