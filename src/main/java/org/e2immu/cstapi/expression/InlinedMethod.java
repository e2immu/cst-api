package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.info.MethodInfo;

public interface InlinedMethod extends Expression {
    MethodInfo methodInfo();

    Expression expression();
}
