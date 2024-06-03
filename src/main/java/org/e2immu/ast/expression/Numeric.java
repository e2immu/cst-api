package org.e2immu.ast.expression;

public interface Numeric extends Expression {
    Number getNumber();

    double doubleValue();
}
