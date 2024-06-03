package org.e2immu.ast.expression;

public interface IntConstant extends Numeric, ConstantExpression<Integer> {
    int constant();
}
