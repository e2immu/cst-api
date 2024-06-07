package org.e2immu.cstapi.element;

import java.util.Objects;

/**
 * Source is an object that can provide client-facing information.
 * Statement navigation links statements together, but is entirely optional.
 */
public interface Source extends Comparable<Source> {

    default StatementNavigation statementNavigation() {
        return null;
    }

    default boolean isSameBlock(Source other) {
        StatementNavigation s1 = statementNavigation();
        StatementNavigation s2 = other.statementNavigation();
        return s1 != null && s2 != null && Objects.equals(s1, s2);
    }
}
