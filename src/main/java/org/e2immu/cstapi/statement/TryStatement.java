package org.e2immu.cstapi.statement;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.element.Visitor;
import org.e2immu.cstapi.expression.CatchParameter;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.variable.DescendMode;
import org.e2immu.cstapi.variable.Variable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface TryStatement extends Statement {

    interface CatchClause {
        CatchParameter catchParameter();

        Block block();

        int complexity();

        Stream<TypeReference> typesReferenced();

        Stream<Variable> variables(DescendMode descendMode);

        void visit(Predicate<Element> predicate);

        void visit(Visitor visitor);
        
        interface Builder {
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
