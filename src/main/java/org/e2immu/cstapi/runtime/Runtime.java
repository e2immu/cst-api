package org.e2immu.cstapi.runtime;

import org.e2immu.cstapi.info.ComputeMethodOverrides;
import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.info.TypeInfo;

public interface Runtime extends Predefined, Factory, Eval, Types {

    Configuration configuration();

    ComputeMethodOverrides computeMethodOverrides();
}
