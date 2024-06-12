package org.e2immu.cstapi.expression;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.element.Source;
import org.e2immu.cstapi.output.OutputBuilder;
import org.e2immu.cstapi.variable.Variable;

public interface VariableExpression extends Expression {

    Variable variable();

    VariableExpression withSuffix(Suffix suffix);

    interface Suffix {
        OutputBuilder print();
    }

    // no suffix by default
    default Suffix suffix() {
        return null;
    }

    interface VariableField extends Suffix {
        Source latestAssignment();

        int statementTime();
    }

    interface ModifiedVariable extends Suffix {
        Source latestModification();
    }

    interface Builder extends Element.Builder<Builder> {
        @Fluent
        Builder setVariable(Variable variable);

        @Fluent
        Builder setSuffix(Suffix suffix);

        VariableExpression build();
    }
}
