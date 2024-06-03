package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.statement.LocalVariableCreation;

public interface CatchParameter extends Expression {
    LocalVariableCreation localVariableCreation();
}
