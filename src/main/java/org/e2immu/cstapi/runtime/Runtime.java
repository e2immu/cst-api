package org.e2immu.cstapi.runtime;

public interface Runtime extends Predefined, Factory, Eval, Types {

    Configuration configuration();

}
