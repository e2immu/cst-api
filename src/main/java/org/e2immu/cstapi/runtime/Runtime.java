package org.e2immu.cstapi.runtime;

public interface Runtime extends Predefined, Factory, Eval {

    Configuration configuration();

    int limitOnComplexity();
}
