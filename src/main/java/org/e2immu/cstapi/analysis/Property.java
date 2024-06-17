package org.e2immu.cstapi.analysis;

import java.util.stream.Stream;

public interface Property {
    Class<? extends Value> classOfValue();

    String key();
}
