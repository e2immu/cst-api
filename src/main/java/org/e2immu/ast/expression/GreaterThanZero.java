package org.e2immu.ast.expression;

public interface GreaterThanZero extends Expression {
    Expression expression();

    boolean allowEquals();
}
