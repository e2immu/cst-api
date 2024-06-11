package org.e2immu.cstapi.element;

import org.e2immu.cstapi.info.Info;

import java.util.Objects;

public interface Source extends Comparable<Source> {

    Info info();

    default CompilationUnit compilationUnit() {
        Info info = info();
        return info == null ? null : info.compilationUnit();
    }

    default StatementNavigation statementNavigation() {
        return null;
    }

    default boolean isSameBlock(Source other) {
        StatementNavigation s1 = statementNavigation();
        StatementNavigation s2 = other.statementNavigation();
        assert s1 != null && s2 != null;
        return s1.equals(s2);
    }

    int beginLine();

    int beginPos();

    int endLine();

    int endPos();
}
