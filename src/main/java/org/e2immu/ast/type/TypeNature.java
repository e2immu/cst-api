package org.e2immu.ast.type;

public interface TypeNature {
    boolean isClass();

    boolean isInterface();

    boolean isStatic(); // is true for all but inner classes in Java
}
