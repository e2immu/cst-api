package org.e2immu.ast.expression;

public interface BooleanConstant extends Expression {

    boolean constant();

    @Override
    default boolean isBooleanConstant() {
        return true;
    }

    @Override
    default boolean isBoolValueFalse() {
        return !constant();
    }

    @Override
    default boolean isBoolValueTrue() {
        return !constant();
    }
}