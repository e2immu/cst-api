package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.element.Comment;
import org.e2immu.cstapi.element.CompilationUnit;
import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.element.Source;
import org.e2immu.cstapi.expression.*;
import org.e2immu.cstapi.info.*;
import org.e2immu.cstapi.statement.*;
import org.e2immu.cstapi.translate.TranslationMap;
import org.e2immu.cstapi.type.*;
import org.e2immu.cstapi.variable.*;

import java.util.List;

public interface Factory {

    Access accessPackage();

    Access accessPrivate();

    Access accessProtected();

    Access accessPublic();

    ParameterizedType commonType(ParameterizedType pt1, ParameterizedType pt2);

    default BooleanConstant constantFalse() {
        return newBoolean(false);
    }

    default BooleanConstant constantTrue() {
        return newBoolean(true);
    }

    Expression constructorCallWithArrayInitializer(MethodInfo constructor, ParameterizedType returnType, List<Object> of, ArrayInitializer initializer);

    Diamond diamondNo();

    Diamond diamondShowAll();

    Diamond diamondYes();

    Block emptyBlock();

    FieldModifier fieldModifierFinal();

    FieldModifier fieldModifierPrivate();

    FieldModifier fieldModifierProtected();

    FieldModifier fieldModifierPublic();

    FieldModifier fieldModifierStatic();

    FieldModifier fieldModifierTransient();

    FieldModifier fieldModifierVolatile();

    IntConstant intMinusOne();

    IntConstant intOne();

    Numeric intOrDouble(double v);

    IntConstant intZero();

    MethodModifier methodModifierAbstract();

    MethodModifier methodModifierDefault();

    MethodModifier methodModifierFinal();

    MethodModifier methodModifierPrivate();

    MethodModifier methodModifierProtected();

    MethodModifier methodModifierPublic();

    MethodModifier methodModifierStatic();

    MethodModifier methodModifierSynchronized();

    AnnotationExpression.Builder newAnnotationExpressionBuilder();

    ArrayInitializer newArrayInitializer(List<Expression> expressions, ParameterizedType commonType);

    ArrayLength newArrayLength(Expression e);

    AssertStatement.Builder newAssertStatementBuilder();

    Assignment newAssignment(Expression target, Expression value);

    Assignment.Builder newAssignmentBuilder();

    BinaryOperator.Builder newBinaryOperatorBuilder();

    Block.Builder newBlockBuilder();

    BooleanConstant newBoolean(boolean value);

    ByteConstant newByte(byte b);

    Cast newCast(Expression e, ParameterizedType parameterizedType);

    TryStatement.CatchClause.Builder newCatchClauseBuilder();

    CharConstant newChar(char c);

    CompilationUnit.Builder newCompilationUnitBuilder();

    ConstructorCall newConstructorCall(Expression scope, MethodInfo constructor,
                                       ParameterizedType pt, Diamond diamond, List<Expression> parameterExpressions,
                                       TypeInfo anonymousClass, ArrayInitializer arrayInitializer);

    DependentVariable newDependentVariable(Expression array, Expression index);

    DoStatement.Builder newDoBuilder();

    DoubleConstant newDouble(double d);

    EmptyExpression newEmptyExpression();

    EmptyExpression newEmptyExpression(String msg);

    EnclosedExpression newEnclosedExpression(Expression inner);

    Equals newEquals(Expression lhs, Expression rhs);

    ExpressionAsStatement newExpressionAsStatement(Expression standardized);

    ExpressionAsStatement.Builder newExpressionAsStatementBuilder();

    FieldInfo newFieldInfo(String name, boolean isStatic, ParameterizedType parameterizedType, TypeInfo owner);

    FieldReference newFieldReference(FieldInfo fieldInfo);

    FieldReference newFieldReference(FieldInfo fieldInfo, Expression scope, ParameterizedType concreteReturnType);

    FloatConstant newFloat(float f);

    ForEachStatement.Builder newForEachBuilder();

    GreaterThanZero newGreaterThanZero(Expression e, boolean allowEquals);

    IfElseStatement.Builder newIfElseBuilder();

    InlineConditional newInlineConditional(Expression condition, Expression ifTrue, Expression ifFalse);

    Instance newInstanceForTooComplex(ParameterizedType parameterizedType);

    InstanceOf newInstanceOf(ParameterizedType parameterizedType, Expression expression, LocalVariable patternVariable);

    IntConstant newInt(int i);

    Lambda newLambda(ParameterizedType abstractFunctionalType,
                     ParameterizedType implementation,
                     ParameterizedType concreteReturnType,
                     List<Lambda.OutputVariant> outputVariants);

    LocalVariable newLocalVariable(String name, ParameterizedType parameterizedType);

    LocalVariable newLocalVariable(String name, ParameterizedType parameterizedType, Expression assignmentExpression);

    LocalVariableCreation newLocalVariableCreation(LocalVariable lvc);

    LongConstant newLong(long l);

    MethodInfo newMethod(TypeInfo owner);

    MethodInfo newMethod(TypeInfo owner, String name, MethodInfo.MethodType methodType);

    MethodCall newMethodCall(Expression object, MethodInfo methodInfo, List<Expression> parameterExpressions);

    MethodCall.Builder newMethodCallBuilder();

    MethodReference newMethodReference(Expression e, MethodInfo methodInfo, ParameterizedType parameterizedType);

    MethodInfo.MethodType newMethodTypeAbstractMethod();

    MethodInfo.MethodType newMethodTypeConstructor();

    MethodInfo.MethodType newMethodTypeDefaultMethod();

    MethodInfo.MethodType newMethodTypeMethod();

    MethodInfo.MethodType newMethodTypeStaticMethod();

    Expression newMultiExpressions(List<Expression> newExpressions);

    Comment newMultilineComment(String comment);

    ConstructorCall newObjectCreation(Expression scope, MethodInfo constructor, ParameterizedType parameterizedType, Diamond diamond, List<Expression> newParams);

    ParameterizedType newParameterizedType(TypeInfo typeInfo, List<ParameterizedType> newParameters);

    ParameterizedType newParameterizedType(TypeInfo typeInfo, int arrays);

    ParameterizedType newParameterizedType(TypeParameter typeParameter, int index, Wildcard wildCard);

    ParameterizedType newParameterizedType(TypeInfo typeInfo,  int arrays, Wildcard wildCard, List<ParameterizedType> parameters);

    Source newParserSource(Element parent, String index, int beginLine, int beginPos, int endLine, int endPos);

    ReturnStatement.Builder newReturnBuilder();

    ReturnStatement newReturnStatement(Expression expression);

    ShortConstant newShort(short s);

    Comment newSingleLineComment(String comment);

    SwitchEntry newStatementsSwitchEntry(VariableExpression selector,
                                         List<Expression> labels, List<Statement> statements);

    StringConstant newStringConstant(String string);

    SwitchExpression newSwitchExpression(VariableExpression selector,
                                         List<SwitchEntry> switchEntries, ParameterizedType parameterizedType,
                                         List<Expression> expressions);

    SynchronizedStatement.Builder newSynchronizedBuilder();

    This newThis(TypeInfo typeInfo);

    ThrowStatement.Builder newThrowBuilder();

    TranslationMap.Builder newTranslationMapBuilder();

    TranslationMap.Builder newTranslationMapBuilder(TranslationMap startingPoint);

    TryStatement.Builder newTryBuilder();

    TypeExpression newTypeExpression(ParameterizedType parameterizedType, Diamond diamond);

    TypeInfo newTypeInfo(TypeInfo typeInfo, String simpleName);

    TypeInfo newTypeInfo(CompilationUnit cu, String simpleName);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt, TypeInfo owner);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt, List<ParameterizedType> typeBounds, TypeInfo owner);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt, MethodInfo owner);

    TypeParameter newTypeParameter(String typeParameterName, int tpCnt, List<ParameterizedType> typeBounds, MethodInfo owner);

    UnaryOperator newUnaryOperator(MethodInfo operator, Expression e, Precedence precedence);

    VariableExpression newVariableExpression(Variable variable);

    VariableExpression.Builder newVariableExpressionBuilder();

    WhileStatement.Builder newWhileBuilder();

    YieldStatement.Builder newYieldBuilder();

    Expression nullConstant();

    Expression nullValue(TypeInfo typeInfo);

    ConstructorCall objectCreation(Expression scope, MethodInfo constructor, ParameterizedType parameterizedType,
                                   Diamond diamond, List<Expression> parameterExpressions);

    ParameterizedType parameterizedTypeReturnTypeOfConstructor();

    ParameterizedType parameterizedTypeWildcard();

    Precedence precedenceAdditive();

    Precedence precedenceAnd();

    Precedence precedenceAssignment();

    Precedence precedenceEquality();

    Precedence precedenceGreaterThan();

    Precedence precedenceMultiplicative();

    Precedence precedenceOr();

    Precedence precedenceUnary();

    TypeModifier typeModifierAbstract();

    TypeModifier typeModifierFinal();

    TypeModifier typeModifierNonSealed();

    TypeModifier typeModifierPrivate();

    TypeModifier typeModifierProtected();

    TypeModifier typeModifierPublic();

    TypeModifier typeModifierSealed();

    TypeModifier typeModifierStatic();

    TypeNature typeNatureAnnotation();

    TypeNature typeNatureClass();

    TypeNature typeNatureEnum();

    TypeNature typeNatureInterface();

    TypeNature typeNatureRecord();

    Wildcard wildcardExtends();

    Wildcard wildcardSuper();
}
