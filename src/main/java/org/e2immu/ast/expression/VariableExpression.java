package org.e2immu.ast.expression;

import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.variable.Variable;

public interface VariableExpression extends Expression {
    static VariableExpression create(Identifier constant, Variable variable) {
        return new Impl(variable);
    }

    Variable variable();

    default boolean hasSuffix() {
        return getSuffix() != null;
    }

    default Suffix getSuffix() {
        return null;
    }

    record Impl(Variable variable) implements VariableExpression {
        @Override
        public Variable variable() {
            return variable;
        }
    }

    interface Suffix {

    }

    interface VariableField extends Suffix {
        int statementTime();
    }
}
