package org.e2immu.ast.expression;

import java.util.List;

public interface And extends Expression {
    List<Expression> getExpressions();
}
