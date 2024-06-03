package org.e2immu.cstapi.info;

import org.e2immu.cstapi.variable.Variable;

public interface ParameterInfo extends Variable {
    int index();

    String name();

    boolean parameterAnalysisIsSet();
}
