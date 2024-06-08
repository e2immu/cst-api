package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.type.ParameterizedType;

public interface FieldInfo extends Info {
    String name();

    TypeInfo owner();

    ParameterizedType type();

    String fullyQualifiedName();

    // inspection

    boolean isStatic();

    boolean isFinal();

    boolean isTransient();

    boolean isVolatile();


    // analysis

    boolean isPropertyNotNull();

    // as opposed to isFinal, which is the modifier
    boolean isPropertyFinal();


    interface Builder<B extends Builder<?>> extends Info.Builder<B> {

        @Fluent
        B addFieldModifier(FieldModifier fieldModifier);

        @Fluent
        B setInitializer(Expression initializer);

        void commit();
    }
}
