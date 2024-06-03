package org.e2immu.ast.expression;

import org.e2immu.ast.info.MethodInfo;

public interface InlinedMethod extends Expression {
    MethodInfo methodInfo();

    Expression expression();
}
