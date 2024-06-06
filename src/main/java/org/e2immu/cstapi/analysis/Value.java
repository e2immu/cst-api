package org.e2immu.cstapi.analysis;

public interface Value {
    boolean isTrue();

    boolean isFalse();

    interface CommutableData extends Value {
        default boolean isDefault() {
            return par().isBlank() && seq().isBlank() && multi().isBlank();
        }

        default boolean isParallel() {
            return par().isBlank() && seq().isBlank();
        }

        default boolean isSequential() {
            return par().isBlank() && !seq().isBlank();
        }

        String multi();
        String par();
        String seq();
    }
}
