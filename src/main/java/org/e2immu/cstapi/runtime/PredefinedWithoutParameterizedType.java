package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.*;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.TypeInfo;

public interface PredefinedWithoutParameterizedType {

    Expression nullValue(TypeInfo typeInfo);

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

    Numeric intOrDouble(double v);

    Expression nullConstant();

    BooleanConstant newBooleanConstant(boolean b);

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

    Precedence precedenceAND();

    Precedence precedenceOR();

    Precedence precedenceASSIGNMENT();

    Precedence precedenceMULTIPLICATIVE();

    Precedence precedenceADDITIVE();

    TypeInfo unboxed(TypeInfo typeInfo);

    IntConstant newIntConstant(int i);

    TypeInfo booleanTypeInfo();

    TypeInfo boxedBooleanTypeInfo();
}
