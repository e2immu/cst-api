package org.e2immu.cstapi.expression;

public interface GreaterThanZero extends Expression {
    Expression expression();

    boolean allowEquals();
}
