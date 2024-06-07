package org.e2immu.cstapi.element;

import org.e2immu.cstapi.info.MethodInfo;
import org.e2immu.cstapi.statement.Statement;

public interface StatementNavigation {

    interface Index {

    }

    StatementNavigation parent();

    Statement statement();

    MethodInfo currentMethod();

    Index index();

    StatementNavigation next();


    StatementNavigation jumpTo(Index index);
}
