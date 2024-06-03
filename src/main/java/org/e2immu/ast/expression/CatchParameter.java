package org.e2immu.ast.expression;

import org.e2immu.ast.statement.LocalVariableCreation;

public interface CatchParameter extends Expression {
    LocalVariableCreation localVariableCreation();
}
