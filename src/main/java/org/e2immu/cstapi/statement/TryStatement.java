package org.e2immu.cstapi.statement;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.expression.CatchParameter;
import org.e2immu.cstapi.expression.Expression;

import java.util.List;

public interface TryStatement extends Statement {

    interface CatchClause extends Element {
        CatchParameter catchParameter();

        Block block();

        interface Builder extends Element.Builder<CatchClause.Builder> {
            @Fluent
            Builder setBlock(Block block);

            @Fluent
            Builder setCatchParameter(CatchParameter catchParameter);

            CatchClause build();
        }
    }

    Block finallyBlock();

    List<CatchClause> catchClauses();

    List<LocalVariableCreation> resources();

    interface Builder extends Statement.Builder<Builder> {

        @Fluent
        Builder setBlock(Block block);

        @Fluent
        Builder setFinallyBlock(Block block);

        @Fluent
        Builder addCatchClause(CatchClause catchClause);

        @Fluent
        Builder addResource(LocalVariableCreation localVariableCreation);

        TryStatement build();
    }
}
