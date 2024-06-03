package org.e2immu.ast.expression;

public interface InlineConditional extends Expression {
    Expression ifTrue();

    Expression ifFalse();

    Expression condition();
}
