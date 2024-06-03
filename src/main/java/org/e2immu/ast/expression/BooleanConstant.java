package org.e2immu.ast.expression;

public interface BooleanConstant extends Expression {

    boolean constant();

    @Override
    default boolean isBooleanConstant() {
        return true;
    }

    record Impl(boolean value) implements BooleanConstant {
        @Override
        public boolean isBoolValueTrue() {
            return value;
        }

        @Override
        public boolean isBoolValueFalse() {
            return !value;
        }

        @Override
        public boolean constant() {
            return value;
        }
    }
}
