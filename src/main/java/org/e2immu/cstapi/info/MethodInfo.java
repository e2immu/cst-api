package org.e2immu.cstapi.info;

import org.e2immu.cstapi.element.Source;
import org.e2immu.cstapi.type.ParameterizedType;

import java.util.Set;

public interface MethodInfo {
    boolean isConstructor();

    TypeInfo primaryType();

    TypeInfo getTypeInfo();

    boolean methodAnalysisIsSet();

    boolean isDefault();

    boolean isVoid();

    boolean getComplexity();

    boolean complexityGreaterThanCOMPLEXITY_METHOD_WITHOUT_CODE();

    boolean hasReturnValue();

    enum MethodType {
        METHOD, CONSTRUCTOR, STATIC_METHOD,
    }
    String name();

    String distinguishingName();

    String fullyQualifiedName();

    TypeInfo typeInfo();

    boolean isStatic();

    ParameterizedType returnType();

    Source newLocation();
    
    Set<MethodInfo> topOfOverloadingHierarchy();


    boolean isModifying();
    boolean isOverloadOfJLOEquals();
}

