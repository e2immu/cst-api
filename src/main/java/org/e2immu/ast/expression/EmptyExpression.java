package org.e2immu.ast.expression;

public interface EmptyExpression extends Expression {
    EmptyExpression EMPTY_EXPRESSION = new Impl();
    EmptyExpression NO_RETURN_VALUE = new Impl();
    EmptyExpression DEFAULT_EXPRESSION = new Impl();

    @Override
    default boolean isEmpty() {
        return true;
    }

    record Impl() implements EmptyExpression {

    }
}
