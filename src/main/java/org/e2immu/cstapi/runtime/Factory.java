package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.element.Comment;
import org.e2immu.cstapi.expression.*;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.MethodModifier;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.statement.*;
import org.e2immu.cstapi.type.*;
import org.e2immu.cstapi.variable.DependentVariable;
import org.e2immu.cstapi.variable.LocalVariable;
import org.e2immu.cstapi.variable.This;
import org.e2immu.cstapi.variable.Variable;

import java.util.List;

public interface Factory {

    TypeNature typeNatureCLASS();

    Assignment createAssignment(Expression target, Expression value);

    Equals newEquals(Expression lhs, Expression rhs);

    InstanceOf newInstanceOf(ParameterizedType parameterizedType, Expression expression, LocalVariable patternVariable);

    BinaryOperator newBinaryOperator(Expression lhs, MethodInfo operator, Expression rhs, Precedence precedence);

    MethodCall newMethodCall(boolean b, Expression newObject, MethodInfo methodInfo, ParameterizedType parameterizedType, List<Expression> newParams);

    ConstructorCall newObjectCreation(Expression scope, MethodInfo constructor, ParameterizedType parameterizedType, Diamond diamond, List<Expression> newParams);

    GreaterThanZero newGreaterThanZero(Expression e, boolean allowEquals);

    Cast newCast(Expression e, ParameterizedType parameterizedType);

    MethodReference newMethodReference(Expression e, MethodInfo methodInfo, ParameterizedType parameterizedType);

    UnaryOperator newUnaryOperator(MethodInfo operator, Expression e, Precedence precedence);

    ArrayLength newArrayLength(Expression e);

    MethodCall newMethodCall(Expression object, MethodInfo takeWhile, List<Expression> parameterExpressions);

    TypeExpression newTypeExpression(ParameterizedType parameterizedType, Diamond diamond);

    ConstructorCall newConstructorCall(Expression scope, MethodInfo constructor,
                                       ParameterizedType pt, Diamond diamond, List<Expression> parameterExpressions,
                                       TypeInfo anonymousClass, ArrayInitializer arrayInitializer);

    IfElseStatement createIfElseStatement(String label, Expression condition, Block ifBlock, Block elseBlock, Comment comment);

    ExpressionAsStatement createExpressionAsStatement(Expression standardized);

    ThrowStatement createThrowStatement(String label, Expression expression, Comment comment);

    AssertStatement createAssertStatement(String label, Expression check, Expression message);

    ReturnStatement createReturnStatement(Expression expression);

    WhileStatement createWhileStatement(String label, Expression loopCondition, Block block, Comment comment);

    Block.Builder newBlockBuilder();

    Block emptyBlock();

    Assignment createAssignment(Expression target, Expression value,
                                MethodInfo assignmentOperator, Boolean prefixPrimitiveOperator,
                                boolean complainAboutAssignmentOutsideType, boolean allowStaticallyAssigned,
                                EvaluationResult evaluationOfValue);

    VariableExpression newVariableExpression(Variable variable);

    StringConstant newStringConstant(String string);

    ConstructorCall objectCreation(Expression scope, MethodInfo constructor, ParameterizedType parameterizedType, Diamond diamond, List<Expression> parameterExpressions);

    TypeInfo newTypeInfo(TypeInfo typeInfo, String capitalized);

    ParameterizedType newParameterizedType(TypeInfo typeInfo, List<ParameterizedType> newParameters);

    ParameterizedType newParameterizedType(TypeInfo typeInfo, int arrays);

    ParameterizedType newParameterizedType(TypeParameter typeParameter, int index, Wildcard wildCard);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt);

    ParameterizedType WILDCARD_PARAMETERIZED_TYPE();

    ParameterizedType parameterizedTypeRETURN_TYPE_OF_CONSTRUCTOR();

    Diamond diamondYES();

    Diamond diamondNO();

    Expression constructorCallWithArrayInitializer(MethodInfo constructor, ParameterizedType returnType, List<Object> of, ArrayInitializer initializer);

    MethodModifier methodModifierSTATIC();

    MethodModifier methodModifierPUBLIC();


    // make sure to use context.newAnd(..) when context available
    And createAnd(List<Expression> expressions);

    And createAnd(Expression... expressions);

    // make sure to use context.newOr(..) when context available
    Or createOr(List<Expression> expressions);

    InlineConditional newInlineConditional(Expression condition, Expression ifTrue, Expression ifFalse);


    SwitchExpression newSwitchExpression(VariableExpression selector,
                                         List<SwitchEntry> switchEntries, ParameterizedType parameterizedType,
                                         List<Expression> expressions);

    SwitchEntry newStatementsSwitchEntry(VariableExpression selector,
                                         List<Expression> labels, List<Statement> statements);

    MethodCall newMethodCall(boolean objectIsImplicit, Expression object,
                             MethodInfo methodInfo, ParameterizedType parameterizedType,
                             List<Expression> expressions, String modificationTimes);

    CharConstant newCharConstant(char c);

    This newThis(TypeInfo typeInfo);

    Expression newVariableExpression(Variable variable,
                                     VariableExpression.Suffix suffix, Expression scope, Expression index);

    DependentVariable createDependentVariable(Expression array, Expression index,
                                              String statementIndex, TypeInfo owningType);

    Expression newMultiExpressions(List<Expression> newExpressions);

    BooleanConstant newBooleanConstant(boolean value);

    default BooleanConstant constantTrue() {
        return newBooleanConstant(true);
    }

    default BooleanConstant constantFalse() {
        return newBooleanConstant(false);
    }

    IntConstant zero();

    IntConstant one();

    IntConstant minusOne();


    Instance newInstanceForTooComplex(ParameterizedType parameterizedType);
}
