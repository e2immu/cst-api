package org.e2immu.cstapi.expression;


import org.e2immu.cstapi.runtime.EvaluationResult;

import java.util.stream.Stream;

public interface Sum extends BinaryOperator {

    static Expression wrapInSum(EvaluationResult context, Expression[] translated, int length) {
        return null;
    }

    public static Stream<Expression> expandTerms(EvaluationResult evaluationContext, Expression expression, boolean negate) {
        Sum sum;
        if ((sum = expression.asInstanceOf(Sum.class)) != null) {
            return Stream.concat(expandTerms(evaluationContext, sum.lhs(), negate),
                    expandTerms(evaluationContext, sum.rhs(), negate));
        }
        if (negate) {
            return Stream.of(evaluationContext.negate(expression));
        }
        return Stream.of(expression);
    }
}
