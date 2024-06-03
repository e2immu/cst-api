package org.e2immu.ast.expression.util;

import org.e2immu.ast.expression.Expression;

import java.util.Arrays;
import java.util.stream.Stream;

public interface MultiExpression {

    static MultiExpression create(Expression[] expressions) {
        return new Impl(expressions);
    }

    record Impl(Expression[] expressions) implements MultiExpression {

        @Override
        public Stream<Expression> stream() {
            return Arrays.stream(expressions);
        }
    }

    Stream<Expression> stream();
}
