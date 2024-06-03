package org.e2immu.ast.expression;

import org.e2immu.ast.element.Element;
import org.e2immu.ast.type.ParameterizedType;

public interface Expression extends Comparable<Expression>, Element {

    ParameterizedType returnType();

    // convenience methods

    default boolean isBoolValueTrue() {
        return false;
    }

    default boolean isBoolValueFalse() {
        return false;
    }

    default boolean isBooleanConstant() {
        return false;
    }

    default boolean isNullConstant() {
        return false;
    }

    default boolean isEmpty() {
        return false;
    }

    default boolean isConstant() {
        return false;
    }
}
