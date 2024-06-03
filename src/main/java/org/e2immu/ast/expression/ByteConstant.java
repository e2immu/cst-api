package org.e2immu.ast.expression;

public interface ByteConstant extends Numeric, ConstantExpression<Byte> {
    byte constant();
}
