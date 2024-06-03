package org.e2immu.ast.info;


import org.e2immu.ast.type.NamedType;
import org.e2immu.ast.type.ParameterizedType;

import java.util.Map;

public interface TypeInfo extends NamedType {

    String fullyQualifiedName();

    ParameterizedType asSimpleParameterizedType();

    MethodInfo findUniqueMethod(String methodName, int n);

    MethodInfo findConstructor(int i);

    FieldInfo getFieldByName(String name, boolean complain);

    MethodInfo findUniqueMethod(String tryCatch, TypeInfo typeInfoOfFirstParameter);
}
