package org.e2immu.ast.statement;

public interface ForEachStatement extends LoopStatement {
    LocalVariableCreation initializer();
}
