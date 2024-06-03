package org.e2immu.ast.expression;

public interface NullConstant extends Expression {

    @Override
    default boolean isNullConstant() {
        return true;
    }
}
