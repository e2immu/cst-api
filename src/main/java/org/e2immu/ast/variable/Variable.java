package org.e2immu.ast.variable;

import org.e2immu.ast.type.ParameterizedType;
import org.e2immu.ast.info.TypeInfo;

/**
 * It is important that we can sort variables, as part of the sorting system of Expressions.
 */
public interface Variable extends Comparable<Variable> {
    String fullyQualifiedName();

    String simpleName();

    ParameterizedType parameterizedType();

    TypeInfo getOwningType();

    @Override
    default int compareTo(Variable o) {
        throw new UnsupportedOperationException();
    }

    default boolean isStatic() {
        return false;
    }
}
