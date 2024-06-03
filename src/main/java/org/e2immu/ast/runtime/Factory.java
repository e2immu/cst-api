package org.e2immu.ast.runtime;

import org.e2immu.ast.element.Comment;
import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.expression.*;
import org.e2immu.ast.expression.util.MultiExpression;
import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.info.MethodModifier;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.statement.*;
import org.e2immu.ast.type.Diamond;
import org.e2immu.ast.type.ParameterizedType;
import org.e2immu.ast.type.TypeNature;
import org.e2immu.ast.type.TypeParameter;
import org.e2immu.ast.variable.DependentVariable;
import org.e2immu.ast.variable.LocalVariableReference;
import org.e2immu.ast.variable.Variable;

import java.util.List;

public interface Factory {

    TypeNature typeNatureCLASS();

    Assignment createAssignment(VariableExpression target, Expression value);

    Assignment createAssignment(Identifier identifier, Expression target, Expression value);




    Equals newEquals(Identifier constant, Expression lhs, Expression rhs);

    InstanceOf newInstanceOf(Identifier identifier, ParameterizedType parameterizedType, Expression expression, LocalVariableReference patternVariable);

    BinaryOperator newBinaryOperator(Identifier identifier, Expression lhs, MethodInfo operator, Expression rhs, Precedence precedence);

    MethodCall newMethodCall(Identifier identifier, boolean b, Expression newObject, MethodInfo methodInfo, ParameterizedType parameterizedType, List<Expression> newParams);

    ConstructorCall newObjectCreation(Identifier identifier, Expression scope, MethodInfo constructor, ParameterizedType parameterizedType, Diamond diamond, List<Expression> newParams);

    GreaterThanZero newGreaterThanZero(Identifier identifier, Expression e, boolean allowEquals);

    Assignment createAssignment(Expression target, Expression ee);

    Cast newCast(Identifier identifier, Expression e, ParameterizedType parameterizedType);

    MethodReference newMethodReference(Identifier identifier, Expression e, MethodInfo methodInfo, ParameterizedType parameterizedType);

    UnaryOperator newUnaryOperator(Identifier identifier, MethodInfo operator, Expression e, Precedence precedence);

    ArrayLength newArrayLength(Identifier identifier, Expression e);

    MethodCall newMethodCall(Identifier constant, Expression object, MethodInfo takeWhile, List<Expression> parameterExpressions);

    TypeExpression newTypeExpression(Identifier constant, ParameterizedType parameterizedType, Diamond diamond);

    ConstructorCall newConstructorCall(Identifier constant, Expression scope, MethodInfo constructor,
                                       ParameterizedType pt, Diamond diamond, List<Expression> parameterExpressions,
                                       TypeInfo anonymousClass, ArrayInitializer arrayInitializer);

    IfElseStatement createIfElseStatement(Identifier identifier, String label, Expression condition, Block ifBlock, Block elseBlock, Comment comment);

    ExpressionAsStatement createExpressionAsStatement(Identifier identifier, Expression standardized);

    ThrowStatement createThrowStatement(Identifier identifier, String label, Expression expression, Comment comment);

    AssertStatement createAssertStatement(Identifier identifier, String label, Expression check, Expression message);

    ReturnStatement createReturnStatement(Identifier identifier, Expression expression);

    WhileStatement createWhileStatement(Identifier constant, String label, Expression loopCondition, Block block, Comment comment);

    Block.BlockBuilder newBlockBuilder(Identifier identifier);

    Block emptyBlock(Identifier identifier);

    Assignment createAssignment(Identifier identifier, Expression target, Expression value,
                                MethodInfo assignmentOperator, Boolean prefixPrimitiveOperator,
                                boolean complainAboutAssignmentOutsideType, boolean allowStaticallyAssigned,
                                EvaluationResult evaluationOfValue);

    VariableExpression newVariableExpression(Identifier identifier, Variable variable);

    StringConstant newStringConstant(String string);

    ConstructorCall objectCreation(Identifier constant, Expression scope, MethodInfo constructor, ParameterizedType parameterizedType, Diamond diamond, List<Expression> parameterExpressions);


    TypeInfo newTypeInfo(TypeInfo typeInfo, String capitalized);



    ParameterizedType newParameterizedType(TypeInfo typeInfo, List<ParameterizedType> newParameters);

    ParameterizedType newParameterizedType(TypeInfo typeInfo, int arrays);

    ParameterizedType newParameterizedType(TypeParameter typeParameter, int index, ParameterizedType.WildCard wildCard);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt);

    ParameterizedType WILDCARD_PARAMETERIZED_TYPE();

    ParameterizedType parameterizedTypeRETURN_TYPE_OF_CONSTRUCTOR();

    Diamond diamondYES();

    Diamond diamondNO();

    Expression constructorCallWithArrayInitializer(MethodInfo constructor, ParameterizedType returnType, List<Object> of, ArrayInitializer initializer, Identifier constant);

    MethodModifier methodModifierSTATIC();

    MethodModifier methodModifierPUBLIC();


    // make sure to use context.newAnd(..) when context available
    And createAnd(List<Expression> expressions);
    And createAnd(Expression... expressions);

    // make sure to use context.newOr(..) when context available
    Or createOr(List<Expression> expressions);


    SwitchExpression newSwitchExpression(Identifier identifier, VariableExpression selector,
                                         List<SwitchEntry> switchEntries, ParameterizedType parameterizedType,
                                         MultiExpression expressions);

    MultiExpression newMultiExpression();

    SwitchEntry newStatementsSwitchEntry(Identifier identifier, VariableExpression selector,
                                         List<Expression> labels, List<Statement> statements);

    MethodCall newMethodCall(Identifier identifier, boolean objectIsImplicit, Expression object,
                             MethodInfo methodInfo, ParameterizedType parameterizedType,
                             List<Expression> expressions, String modificationTimes);
    CharConstant newCharConstant(Identifier identifier, char c);


    Expression newVariableExpression(Identifier identifier, Variable variable,
                                     VariableExpression.Suffix suffix, Expression scope, Expression index);

    DependentVariable createDependentVariable(Identifier identifier, Expression array, Expression index,
                                              String statementIndex, TypeInfo owningType);

}
