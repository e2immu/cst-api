package org.e2immu.ast.expression;

public interface DoubleConstant extends Numeric, ConstantExpression<Double> {
    double constant();
}
