package org.e2immu.cstapi.type;

import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.info.TypeInfo;
import org.e2immu.cstapi.output.OutputBuilder;
import org.e2immu.cstapi.output.Qualification;
import org.e2immu.cstapi.runtime.Predefined;
import org.e2immu.cstapi.runtime.PredefinedWithoutParameterizedType;
import org.e2immu.cstapi.runtime.Runtime;

import java.util.List;
import java.util.stream.Stream;

public interface ParameterizedType {
    // the different components

    Wildcard wildcard();

    TypeParameter typeParameter();

    TypeInfo typeInfo();

    int arrays();

    List<ParameterizedType> parameters();

    /**
     * @return null in case of an unbound type parameter, in which case "JLO" can be understood.
     */
    TypeInfo bestTypeInfo();

    // identification

    String fullyQualifiedName();

    // print

    OutputBuilder print(Qualification qualification, boolean varArgs, Diamond diamond);

    Stream<Element.TypeReference> typesReferenced();

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

    boolean isNumeric();

    boolean isUnboundTypeParameter();

    // TODO consider moving this to "runtime"
    boolean isAssignableFrom(Runtime runtime, ParameterizedType other);

    String detailedString();

    default boolean isType() {
        return typeInfo() != null;
    }

    TypeInfo toBoxed(Runtime runtime);

    String printForMethodFQN(boolean varArgs, Diamond diamond);

    boolean equalsIgnoreArrays(ParameterizedType other);

    boolean isTypeOfNullConstant();

    ParameterizedType concreteDirectSuperType(ParameterizedType interfaceImplemented);

    ParameterizedType concreteSuperType(ParameterizedType superType);

    ParameterizedType commonType(Runtime runtime, ParameterizedType other);
}
