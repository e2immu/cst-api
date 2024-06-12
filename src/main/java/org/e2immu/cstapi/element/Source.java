package org.e2immu.cstapi.element;

import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.info.Info;
import org.e2immu.cstapi.statement.Statement;
import org.e2immu.cstapi.variable.Variable;

import java.util.Objects;

public interface Source extends Comparable<Source> {

    // for all elements
    Element parent();

    int beginLine();

    int beginPos();

    int endLine();

    int endPos();

    // for statements only
    String index();

    // computations: override if you need to use these frequently

    default Info info() {
        if (this instanceof Info info) return info;
        Element parent = parent();
        if (parent == null) return null;
        Source parentSource = parent.source();
        return parentSource == null ? null : parentSource.info();
    }

    default CompilationUnit compilationUnit() {
        Info info = info();
        return info == null ? null : info.compilationUnit();
    }
}
