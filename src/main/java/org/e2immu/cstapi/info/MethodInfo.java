package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.annotation.NotNull;
import org.e2immu.cstapi.analysis.Value;
import org.e2immu.cstapi.element.CompilationUnit;
import org.e2immu.cstapi.expression.AnnotationExpression;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.statement.Block;
import org.e2immu.cstapi.type.ParameterizedType;
import org.e2immu.cstapi.type.TypeParameter;
import org.e2immu.cstapi.util.ParSeq;

import java.util.*;

public interface MethodInfo extends Info {

    boolean isConstructor();

    boolean isOverloadOfJLOMethod();

    boolean isSynchronized();

    TypeInfo primaryType();

    boolean isDefault();

    boolean isVoid();

    boolean complexityGreaterThanCOMPLEXITY_METHOD_WITHOUT_CODE();

    default boolean hasReturnValue() {
        return !isVoid() && !isConstructor();
    }

    boolean isPostfix();

    boolean isInfix();

    boolean isSynthetic();

    boolean isAbstract();

    interface MethodType {
        boolean isStatic();

        boolean isConstructor();
    }

    String name();

    String fullyQualifiedName();

    TypeInfo typeInfo();

    boolean isStatic();

    ParameterizedType returnType();

    Set<MethodInfo> topOfOverloadingHierarchy();

    // from inspection

    List<ParameterInfo> parameters();

    List<TypeParameter> typeParameters();

    Block methodBody();

    // from resolution

    boolean isOverloadOf(MethodInfo methodInfo);

    Set<MethodInfo> overrides();

    boolean allowsInterrupts();

    // with inspection

    boolean isPublic();

    boolean isPubliclyAccessible();

    boolean isOverloadOfJLOEquals();

    boolean isCompactConstructor();

    boolean isSyntheticConstructor();

    boolean isStaticBlock();

    // from analysis

    boolean isModifying();

    boolean isFluent();

    boolean isIdentity();

    boolean isStaticSideEffects();

    Map<FieldInfo, Boolean> areOwnFieldsReadModified();

    // related to the commutation of methods

    Value.CommutableData commutableData();

    // related to the commutation of parameters

    Value.ParameterParSeq getParallelGroups();

    default boolean hasParallelGroups() {
        ParSeq<ParameterInfo> parSeq = getParallelGroups().parSeq();
        return parSeq != null && parSeq.containsParallels();
    }

    default List<Expression> sortAccordingToParallelGroupsAndNaturalOrder(List<Expression> parameterExpressions) {
        return getParallelGroups().parSeq().sortParallels(parameterExpressions, Comparator.naturalOrder());
    }

    // this method acts as a getter or setter for this field
    Value.FieldValue getSetField();

    // there is another method without these parameters; they can also be set with setters
    Value.GetSetEquivalent getSetEquivalents();

    Value.PostConditions postConditions();

    Value.Precondition precondition();

    /*
       Many throw and assert statements find their way into a pre- or post-condition.
       Some, however, do not. We register them here.
     */
    Value.IndicesOfEscapes indicesOfEscapesNotInPreOrPostConditions();

    Builder builder();

    boolean isPropertyNotNull();

    boolean isPropertyNullable();

    default CompilationUnit compilationUnit() {
        return typeInfo().compilationUnit();
    }

    interface Builder extends Info.Builder<Builder> {
        /**
         * Intermediate step: the fully qualified name can now be computed, because all
         * parameters are known.
         *
         * @return the builder
         */
        @Fluent
        Builder commitParameters();

        @Fluent
        Builder setMethodBody(Block block);

        @Fluent
        Builder addMethodModifier(MethodModifier methodModifier);

        /**
         * This method directly commits the builder, without any changes.
         */
        @Fluent
        Builder addAndCommitParameter(String name, ParameterizedType type);

        @Fluent
        Builder setReturnType(ParameterizedType returnType);

        ParameterInfo addParameter(String name, ParameterizedType type);

        @Fluent
        Builder addTypeParameter(TypeParameter typeParameter);
    }
}

