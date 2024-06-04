package org.e2immu.cstapi.info;


import org.e2immu.cstapi.type.NamedType;
import org.e2immu.cstapi.type.ParameterizedType;

public interface TypeInfo extends NamedType {

    String fullyQualifiedName();

    ParameterizedType asSimpleParameterizedType();

    MethodInfo findUniqueMethod(String methodName, int n);

    MethodInfo findConstructor(int i);

    FieldInfo getFieldByName(String name, boolean complain);

    MethodInfo findUniqueMethod(String tryCatch, TypeInfo typeInfoOfFirstParameter);

    // for java, that will be packageName == "java.lang"
    boolean doesNotRequirePackage();

    boolean isPrimaryType();

    // chain of type names Primary.Sub.Sub2
    String fromPrimaryTypeDownwards();
}
