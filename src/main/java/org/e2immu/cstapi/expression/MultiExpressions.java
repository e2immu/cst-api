package org.e2immu.cstapi.expression;


import java.util.List;

public interface MultiExpressions extends Expression {

    List<Expression> expressions();
}
