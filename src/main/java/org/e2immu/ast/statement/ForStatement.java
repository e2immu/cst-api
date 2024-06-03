package org.e2immu.ast.statement;

import org.e2immu.ast.element.Element;
import org.e2immu.ast.expression.Expression;

import java.util.List;

public interface ForStatement extends LoopStatement {
    // can be either a LocalVariableCreation (Statement) or any expression
    List<Element> initializers();

    List<Expression> updaters();

    // condition == expression()
}
