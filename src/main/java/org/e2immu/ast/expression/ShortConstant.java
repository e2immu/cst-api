package org.e2immu.ast.expression;

public interface ShortConstant extends Numeric, ConstantExpression<Short> {
    int constant();
}
