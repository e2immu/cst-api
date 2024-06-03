package org.e2immu.ast.expression;

public interface EmptyExpression extends Expression {

    boolean isDefaultExpression();

    boolean isNoReturnValue();

    boolean isNoExpression();

    @Override
    default boolean isEmpty() {
        return true;
    }


}
