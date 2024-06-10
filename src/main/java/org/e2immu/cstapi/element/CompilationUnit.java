package org.e2immu.cstapi.element;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.info.TypeInfo;

import java.net.URI;
import java.util.List;

public interface CompilationUnit extends Element {

    URI uri();

    String packageName();

    List<ImportStatement> importStatements();

    List<TypeInfo> types();

    interface Builder extends Element.Builder<Builder> {

        @Fluent
        Builder setURI(URI uri);

        @Fluent
        Builder addImportStatement(ImportStatement importStatement);

        @Fluent
        Builder addType(TypeInfo typeInfo);

        @Fluent
        Builder setPackageName(String packageName);

        CompilationUnit build();
    }
}
