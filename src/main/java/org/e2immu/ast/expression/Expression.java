package org.e2immu.ast.expression;

import org.e2immu.ast.element.Element;
import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.type.ParameterizedType;

public interface Expression extends Comparable<Expression>, Element {

    default boolean isBoolValueTrue() {
        return false;
    }

    default Identifier getIdentifier() {
        return Identifier.CONSTANT;
    }

    default ParameterizedType returnType() {
        throw new UnsupportedOperationException();
    }

    default boolean isBoolValueFalse() {
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

    default boolean isBooleanConstant() {
        return false;
    }

    @Override
    default int compareTo(Expression o) {
        throw new UnsupportedOperationException();
    }
}
