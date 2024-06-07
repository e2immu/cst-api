package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.Element;

public interface Info extends Element {
    Access access();

    interface Builder extends Element.Builder {
        @Fluent
        Builder setAccess(Access access);
    }

}
