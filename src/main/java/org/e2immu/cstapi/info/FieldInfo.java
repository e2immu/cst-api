package org.e2immu.cstapi.info;

import org.e2immu.cstapi.type.ParameterizedType;

public interface FieldInfo {
    String name();

    TypeInfo owner();

    ParameterizedType type();

    String fullyQualifiedName();

    boolean isStatic();
}
