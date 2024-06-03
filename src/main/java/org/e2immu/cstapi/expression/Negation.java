package org.e2immu.cstapi.expression;

public interface Negation extends Expression, Negatable {

    Expression expression();

    @Override
    default boolean isNegatedOrNumericNegative() {
        return true;
    }
}
