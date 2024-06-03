package org.e2immu.ast.runtime;

import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.expression.Assignment;
import org.e2immu.ast.expression.Expression;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.variable.LocalVariableReference;
import org.e2immu.ast.variable.Variable;

import java.util.List;

public interface EvaluationResult {
    Expression getExpression();

    Predefined getPrimitives();

    TypeInfo getCurrentType();

    Expression negate(Expression expression);

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

    EvaluationResult divide(Identifier constant, Expression lhs, Expression rhs);

    Expression product(Expression lhs, Expression rhs);

    Expression safeEvaluation(Expression expression);

    /* equivalent of
    EvaluationResultImpl.Builder builder = new EvaluationResultImpl.Builder(globalData.context());
    Assignment.E2 e2 = assignment.handleBinaryOperator(globalData.context(), EvaluationContextImpl.FWD, lvr, builder);
    return e2.assignedToTarget();
     */
    Expression handleBinaryOperator(Assignment assignment, LocalVariableReference lvr);
    /*
     static Stream<Expression> expandFactors(EvaluationResult evaluationContext, Expression expression) {
        if (expression instanceof Product product) {
            return Stream.concat(expandFactors(evaluationContext, product.lhs()),
                    expandFactors(evaluationContext, product.rhs()));
        }
        return Stream.of(expression);
    }
     */
}
