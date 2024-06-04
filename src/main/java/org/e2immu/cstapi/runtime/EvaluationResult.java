package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.Assignment;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.variable.LocalVariable;
import org.e2immu.cstapi.variable.Variable;

import java.util.List;

public interface EvaluationResult {
    // link to runtime
    Runtime runtime();


    interface Builder {
        EvaluationResult build();

        Builder compose(EvaluationResult evaluationResult);

        Builder setExpression(Expression expression);
    }

    Builder newBuilder();

    Expression expression();

    Predefined getPrimitives();

    TypeInfo getCurrentType();

    default Expression negate(Expression expression) {
        return negate(expression, true);
    }

    Expression negate(Expression expression, boolean allowEqualsToCallContext);

    Expression newOr(List<Expression> list);

    Expression newOr(Expression... list);

    // this is the equivalent of the static method Equals.equals(...)
    Expression equals(Expression expression, Expression expression1);

    Expression newAnd(Expression... clauses);

    EvaluationResult evaluateInlineConditional(Expression c, Expression t, Expression f, boolean b, Variable myself, boolean modifying);

    // equivalent of evaluating with "onlySort"
    EvaluationResult sortAndSimplify(Expression expression);

    //Product.wrapInProduct
    Expression wrapInProduct(Expression[] translated, int length);

    //Sum.sum
    Expression sum(Expression lhs, Expression rhs);

    Expression remainder(Expression lhs, Expression rhs);

    EvaluationResult divide(Expression lhs, Expression rhs);

    Expression product(Expression lhs, Expression rhs);

    Expression safeEvaluation(Expression expression);

    /* equivalent of
    EvaluationResultImpl.Builder builder = new EvaluationResultImpl.Builder(globalData.context());
    Assignment.E2 e2 = assignment.handleBinaryOperator(globalData.context(), EvaluationContextImpl.FWD, lvr, builder);
    return e2.assignedToTarget();
     */
    Expression handleBinaryOperator(Assignment assignment, LocalVariable lv);

    /*
     static Stream<Expression> expandFactors(EvaluationResult evaluationContext, Expression expression) {
        if (expression instanceof Product product) {
            return Stream.concat(expandFactors(evaluationContext, product.lhs()),
                    expandFactors(evaluationContext, product.rhs()));
        }
        return Stream.of(expression);
    }
     */
    int limitOnComplexity();


}
