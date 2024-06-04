package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.runtime.Predefined;

public interface ConstantExpression<T> extends Expression {

    @Override
    default boolean isConstant() {
        return true;
    }

    T constant();
}
