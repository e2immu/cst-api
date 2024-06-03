package org.e2immu.ast.type;

import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.runtime.PredefinedWithoutParameterizedType;

import java.util.List;

public interface ParameterizedType {
    // the different components

    Wildcard wildcard();

    TypeParameter typeParameter();

    TypeInfo typeInfo();

    int arrays();

    List<ParameterizedType> parameters();

    // identification

    String fullyQualifiedName();

    // conversions

    ParameterizedType erased();

    ParameterizedType copyWithArrays(int arrays);

    ParameterizedType copyWithOneFewerArrays();

    ParameterizedType ensureBoxed(PredefinedWithoutParameterizedType predefined);

    ParameterizedType copyWithFewerArrays(int n);

    ParameterizedType copyWithoutArrays();

    // simple checks

    boolean isBoolean();

    boolean isTypeParameter();

    boolean isVoidOrJavaLangVoid();

    boolean isBooleanOrBoxedBoolean();

    boolean isVoid();

    boolean isPrimitiveExcludingVoid();

    boolean isPrimitiveStringClass();

    boolean isJavaLangString();

    boolean isInt();

    boolean isJavaLangObject();

    boolean isFunctionalInterface();
    boolean isBoxedExcludingVoid();

    boolean isWILDCARD_PARAMETERIZED_TYPE();
}
