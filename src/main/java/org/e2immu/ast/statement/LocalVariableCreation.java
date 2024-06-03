package org.e2immu.ast.statement;

import org.e2immu.ast.variable.LocalVariable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface LocalVariableCreation {

    interface Modifier {
        boolean isFinal(); // the only one in Java; in Kotlin, this represents "val"

        boolean isWithoutTypeSpecification(); // Java "var"
    }

    Set<Modifier> modifiers();

    LocalVariable localVariable();

    List<LocalVariable> otherLocalVariables();

    Stream<LocalVariable> localVariableStream();

    /**
     * Convenience method
     *
     * @return all the new local variables created here
     */
    default Set<LocalVariable> newLocalVariables() {
        return localVariableStream().collect(Collectors.toUnmodifiableSet());
    }

    default boolean hasSingleDeclaration() {
        return otherLocalVariables().isEmpty();
    }
}
