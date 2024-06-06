package org.e2immu.cstapi.info;

import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.type.ParameterizedType;

public interface FieldInfo extends Element {
    String name();

    TypeInfo owner();

    ParameterizedType type();

    String fullyQualifiedName();

    boolean isStatic();


    boolean isPropertyFinal();
}
