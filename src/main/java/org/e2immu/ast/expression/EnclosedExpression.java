package org.e2immu.ast.expression;

public interface EnclosedExpression extends Expression {
    Expression inner();
}
