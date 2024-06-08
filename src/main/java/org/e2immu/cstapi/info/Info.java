package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.Element;

public interface Info extends Element {
    Access access();

    interface Builder<B extends Builder<?>> extends Element.Builder<B> {
        @Fluent
        B setAccess(Access access);
    }

}
