package org.e2immu.ast.expression;


import java.util.List;

public interface MultiExpressions extends Expression {

    List<Expression> expressions();
}
