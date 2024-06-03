package org.e2immu.cstapi.expression;

import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.type.ParameterizedType;

public interface Expression extends Comparable<Expression>, Element {

    ParameterizedType parameterizedType();

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

    default boolean isNegatedOrNumericNegative() {
        return false;
    }

   default boolean isNumeric() {
        return false;
   }
}
