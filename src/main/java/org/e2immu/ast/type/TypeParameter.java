package org.e2immu.ast.type;

import org.e2immu.ast.info.MethodInfo;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.support.Either;

import java.util.List;

public interface TypeParameter extends NamedType {

    int getIndex();

    Either<TypeInfo, MethodInfo> getOwner();

    default boolean isMethodTypeParameter() {
        return getOwner().isRight();
    }

    List<ParameterizedType> getTypeBounds();

    ParameterizedType toParameterizedType();
}
