package org.e2immu.ast.expression;

import org.e2immu.ast.variable.Variable;

public interface VariableExpression extends Expression {

    Variable variable();

    // FIXME move to e2immu implementation

    default boolean hasSuffix() {
        return suffix() != null;
    }

    default Suffix suffix() {
        return null;
    }

    interface Suffix {

    }

    interface VariableField extends Suffix {
        int statementTime();
    }
}
