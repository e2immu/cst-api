package org.e2immu.ast.expression;

public interface FloatConstant extends Numeric, ConstantExpression<Float> {
    float constant();
}
