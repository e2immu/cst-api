package org.e2immu.ast.info;

import org.e2immu.ast.element.Identifier;
import org.e2immu.ast.variable.Variable;

public interface ParameterInfo extends Variable {
    int index();

    String name();

    Identifier identifier();

    boolean parameterAnalysisIsSet();
}
