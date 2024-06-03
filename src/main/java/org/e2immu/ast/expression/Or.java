package org.e2immu.ast.expression;

import java.util.List;

public interface Or extends Expression {
    List<Expression> expressions();
}
