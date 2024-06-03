package org.e2immu.ast.info;

import org.e2immu.ast.type.ParameterizedType;

public interface FieldInfo {
    String name();

    TypeInfo owner();

    ParameterizedType type();

    boolean fieldAnalysisIsSet();
}