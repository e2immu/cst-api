package org.e2immu.ast.variable;

import org.e2immu.ast.expression.Expression;

/*
value held by the local variable at the time of creation.
can be null (not known, not relevant)
 */
public interface LocalVariable extends Variable {

    Expression assignmentExpression();

    @Override
    default String fullyQualifiedName() {
        return simpleName();
    }
}
