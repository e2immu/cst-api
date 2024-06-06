package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.info.TypeInfo;

public interface Types {

    TypeInfo getFullyQualified(String name, boolean complain);

    default TypeInfo getFullyQualified(Class<?> clazz, boolean complain) {
        return getFullyQualified(clazz.getCanonicalName(), complain);
    }
}
