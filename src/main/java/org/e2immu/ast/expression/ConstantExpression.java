package org.e2immu.ast.expression;

import org.e2immu.ast.runtime.Predefined;

public interface ConstantExpression<T> extends Expression {
    Predefined primitives();

    @Override
    default boolean isConstant() {
        return true;
    }
}
