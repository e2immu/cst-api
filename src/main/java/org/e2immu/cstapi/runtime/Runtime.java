package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.expression.Expression;

public interface Runtime extends Predefined, Factory, Eval {

    Configuration configuration();

}
