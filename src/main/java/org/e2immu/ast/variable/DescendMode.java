package org.e2immu.ast.variable;

public interface DescendMode {
    boolean isAll(); // all variables, recursively
    boolean isNo(); // all variables, no recursive descend
}
