package org.e2immu.ast.expression;

import org.e2immu.ast.info.TypeInfo;

import java.util.List;

public interface AnnotationExpression {

    interface KV {
        String key();

        /* in Java, that would be "value" */
        boolean keyIsDefault();

        Expression value();
    }

    TypeInfo typeInfo();

    List<KV> keyValuePairs();

}
