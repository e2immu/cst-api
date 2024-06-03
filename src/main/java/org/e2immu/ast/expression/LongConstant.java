package org.e2immu.ast.expression;

public interface LongConstant extends  Numeric, ConstantExpression<Long> {
    long constant();
}
