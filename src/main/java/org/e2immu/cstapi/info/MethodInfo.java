package org.e2immu.cstapi.info;

import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.element.Source;
import org.e2immu.cstapi.type.ParameterizedType;

import java.util.List;
import java.util.Set;

public interface MethodInfo extends Element {
    boolean isConstructor();

    TypeInfo primaryType();

    boolean methodAnalysisIsSet();

    boolean isDefault();

    boolean isVoid();

    int complexity();

    boolean complexityGreaterThanCOMPLEXITY_METHOD_WITHOUT_CODE();

    default boolean hasReturnValue() {
        return !isVoid() && !isConstructor();
    }

    boolean isPostfix();

    boolean isInfix();

    enum MethodType {
        METHOD, CONSTRUCTOR, STATIC_METHOD;
    }

    String name();

    String fullyQualifiedName();

    TypeInfo typeInfo();

    boolean isStatic();

    ParameterizedType returnType();

    Set<MethodInfo> topOfOverloadingHierarchy();

    // from inspection

    List<ParameterInfo> parameters();

    // from resolution
    boolean isOverloadOf(MethodInfo methodInfo);

    // with inspection
    boolean isOverloadOfJLOEquals();

    // from analysis
    boolean isModifying();

    boolean isCompactConstructor();

    boolean isSyntheticConstructor();

    boolean isStaticBlock();

    boolean isFluent();
}

