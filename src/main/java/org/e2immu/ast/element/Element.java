package org.e2immu.ast.element;

import org.e2immu.annotation.ImmutableContainer;
import org.e2immu.annotation.NotNull;
import org.e2immu.annotation.rare.IgnoreModifications;
import org.e2immu.ast.info.TypeInfo;
import org.e2immu.ast.output.OutputBuilder;
import org.e2immu.ast.output.PrintInfo;
import org.e2immu.ast.variable.DescendMode;
import org.e2immu.ast.variable.Variable;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents an element in the Abstract Syntax Tree.
 * Each element has a
 * <ol>
 *     <li>Source: non-essential client-facing information about where in the source this element sits, meant
 *     for error reporting</li>
 *     <li>zero or more Comments: as attached to this element; non-essential to almost all proceedings.</li>
 *     <li>Complexity: used in computations, to avoid expanding expressions beyond reasonable limits</li>
 * </ol>
 * Each element can
 * <ul>
 *     <li>be printed, using the <code>print(PrintInfo)</code> method</li>
 *     <li>be visited recursively, using the <code>visitor</code> methods and the {@link Visitor} interface</li>
 *     <li>be cast, using two dedicated methods that allow one to override the type system (for wrappers)</li>
 *     <li>have its variables listed</li>
 *     <li>have its types referenced listed, as an efficient system to compute import statements</li>
 * </ul>
 */
@ImmutableContainer
public interface Element {
    int getComplexity();

    @NotNull
    List<Comment> comments();

    @NotNull
    Source source();

    void visit(@NotNull Predicate<Element> predicate);

    /**
     * this variant can go inside the variable hierarchy as well
     *
     * @param visitor the visitor object that's being called recursively
     */
    void visit(@NotNull @IgnoreModifications Visitor visitor);

    @NotNull
    OutputBuilder print(PrintInfo qualification);

    @SuppressWarnings("unchecked")
    default <T extends Element> T asInstanceOf(Class<T> clazz) {
        if (clazz.isAssignableFrom(getClass())) {
            return (T) this;
        }
        return null;
    }

    default boolean isInstanceOf(Class<? extends Element> clazz) {
        return clazz.isAssignableFrom(getClass());
    }

    /**
     * Construct a stream of all variables occurring in this element.
     *
     * @param descendMode null for the default descend mode "YES"
     * @return a stream of all variables in this element; variables may occur multiple times.
     * The order is based on the normal recursive descend
     */
    @NotNull
    Stream<Variable> variables(DescendMode descendMode);

    @NotNull
    default List<Variable> variableList() {
        return variables(null).toList();
    }

    @NotNull
    default Set<Variable> variableSet() {
        return variables(null).collect(Collectors.toUnmodifiableSet());
    }

    interface TypeReference {
        /**
         * @return true if the reference to the type is explicit, i.e., it must appear in an import statement
         */
        boolean isExplicit();
    }

    @NotNull
    Stream<TypeReference> typesReferenced();
}