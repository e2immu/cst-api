package org.e2immu.ast.statement;

import org.e2immu.ast.expression.LocalVariableCreation;

public interface ForEachStatement extends LoopStatement {
    LocalVariableCreation getInitializer();
}
