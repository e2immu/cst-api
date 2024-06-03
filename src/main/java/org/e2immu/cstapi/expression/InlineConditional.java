package org.e2immu.cstapi.expression;

public interface InlineConditional extends Expression {
    Expression ifTrue();

    Expression ifFalse();

    Expression condition();
}
