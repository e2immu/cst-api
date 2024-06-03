package org.e2immu.ast.variable;

import org.e2immu.ast.expression.Expression;

public interface DependentVariable extends Variable{
    Variable arrayVariable();

    Variable indexVariable();

    Expression arrayExpression();

    Expression indexExpression();
}
