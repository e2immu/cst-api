package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.*;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.type.ParameterizedType;

public interface PredefinedWithoutParameterizedType {

    TypeInfo boxed(TypeInfo typeInfo);

    MethodInfo equalsOperatorObject();

    MethodInfo notEqualsOperatorObject();

    MethodInfo plusOperatorString();

    MethodInfo equalsOperatorInt();

    MethodInfo lessOperatorInt();

    MethodInfo lessEqualsOperatorInt();

    MethodInfo greaterOperatorInt();

    MethodInfo greaterEqualsOperatorInt();

    MethodInfo notEqualsOperatorInt();

    TypeInfo objectTypeInfo();

    MethodInfo plusOperatorInt();

    MethodInfo multiplyOperatorInt();

    MethodInfo minusOperatorInt();

    MethodInfo divideOperatorInt();
    MethodInfo andOperatorBool();

    MethodInfo orOperatorBool();

    MethodInfo andOperatorInt();

    MethodInfo orOperatorInt();

    MethodInfo bitwiseXorOperatorInt();

    TypeInfo stringTypeInfo();

    TypeInfo unboxed(TypeInfo typeInfo);


    TypeInfo booleanTypeInfo();

    TypeInfo boxedBooleanTypeInfo();

    MethodInfo assignOperatorInt();

    MethodInfo assignPlusOperatorInt();

    MethodInfo assignMinusOperatorInt();

    MethodInfo assignMultiplyOperatorInt();

    MethodInfo assignDivideOperatorInt();

    MethodInfo assignOrOperatorInt();

    MethodInfo assignAndOperatorInt();

    MethodInfo assignLeftShiftOperatorInt();

    MethodInfo assignSignedRightShiftOperatorInt();

    MethodInfo assignUnsignedRightShiftOperatorInt();

    MethodInfo assignXorOperatorInt();

    MethodInfo assignRemainderOperatorInt();

    MethodInfo xorOperatorInt();

    MethodInfo xorOperatorBool();

    MethodInfo leftShiftOperatorInt();

    MethodInfo signedRightShiftOperatorInt();

    MethodInfo unsignedRightShiftOperatorInt();

    MethodInfo remainderOperatorInt();


    int primitiveTypeOrder(ParameterizedType pt);

    int reversePrimitiveTypeOrder(ParameterizedType pt);

    TypeInfo primitiveByName(String asString);



    TypeInfo charTypeInfo();

    ParameterizedType byteParameterizedType();

    TypeInfo classTypeInfo();

    ParameterizedType objectParameterizedType();

    ParameterizedType voidParameterizedType();

    ParameterizedType stringParameterizedType();

    MethodInfo unaryPlusOperatorInt();

    MethodInfo prefixIncrementOperatorInt();

    MethodInfo postfixIncrementOperatorInt();

    MethodInfo prefixDecrementOperatorInt();

    MethodInfo postfixDecrementOperatorInt();

    MethodInfo bitWiseNotOperatorInt();

    TypeInfo integerTypeInfo();

    TypeInfo intTypeInfo();

    TypeInfo characterTypeInfo();

    AnnotationExpression functionalInterfaceAnnotationExpression();

    MethodInfo assignOperator(ParameterizedType parameterizedType);

    MethodInfo unaryMinusOperatorInt();

    MethodInfo logicalNotOperatorBool();

    int isAssignableFromTo(ParameterizedType from, ParameterizedType to, boolean covariant);

    boolean isPreOrPostFixOperator(MethodInfo operator);

    boolean isPrefixOperator(MethodInfo operator);

    MethodInfo prePostFixToAssignment(MethodInfo operator);
}
