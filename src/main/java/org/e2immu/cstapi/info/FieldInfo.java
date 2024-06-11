package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.CompilationUnit;
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

    default CompilationUnit compilationUnit() {
        return owner().compilationUnit();
    }

    Builder builder();

    interface Builder extends Info.Builder<Builder> {

        @Fluent
        Builder addFieldModifier(FieldModifier fieldModifier);

        @Fluent
        Builder setInitializer(Expression initializer);

        void commit();
    }
}
