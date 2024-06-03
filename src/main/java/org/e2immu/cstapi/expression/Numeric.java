package org.e2immu.cstapi.expression;

public interface Numeric extends Expression {
    Number getNumber();

    double doubleValue();

    @Override
    default boolean isNegatedOrNumericNegative() {
        return doubleValue() < 0;
    }

    @Override
    default boolean isNumeric() {
        return true;
    }
}
