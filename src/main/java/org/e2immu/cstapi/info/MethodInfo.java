package org.e2immu.cstapi.info;

import org.e2immu.annotation.Fluent;
import org.e2immu.cstapi.analysis.Value;
import org.e2immu.cstapi.element.Element;
import org.e2immu.cstapi.element.Source;
import org.e2immu.cstapi.expression.AnnotationExpression;
import org.e2immu.cstapi.expression.Expression;
import org.e2immu.cstapi.statement.Block;
import org.e2immu.cstapi.type.ParameterizedType;
import org.e2immu.cstapi.type.TypeParameter;
import org.e2immu.cstapi.util.ParSeq;

import java.util.List;
import java.util.Set;

public interface MethodInfo extends Info {
    boolean isConstructor();

    TypeInfo primaryType();

    boolean methodAnalysisIsSet();

    boolean isDefault();

    boolean isVoid();

    boolean complexityGreaterThanCOMPLEXITY_METHOD_WITHOUT_CODE();

    default boolean hasReturnValue() {
        return !isVoid() && !isConstructor();
    }

    boolean isPostfix();

    boolean isInfix();

    boolean isSynthetic();

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

    List<AnnotationExpression> annotations();

    Block methodBody();

    // from resolution

    boolean isOverloadOf(MethodInfo methodInfo);

    Set<MethodInfo> overrides();

    // with inspection

    boolean isPublic();

    boolean isPubliclyAccessible();

    boolean isOverloadOfJLOEquals();

    // from analysis
    boolean isModifying();

    boolean isCompactConstructor();

    boolean isSyntheticConstructor();

    boolean isStaticBlock();

    boolean isFluent();

    // related to commutation of parameters

    Value.CommutableData commutableData();

    ParSeq<ParameterInfo> getParallelGroups();

    default boolean hasParallelGroups() {
        ParSeq<ParameterInfo> parSeq = getParallelGroups();
        return parSeq != null && parSeq.containsParallels();
    }

    List<Expression> sortAccordingToParallelGroupsAndNaturalOrder(List<Expression> parameterExpressions);


    Builder builder();

    boolean isPropertyNotNull();

    boolean isPropertyNullable();

    interface Builder extends Info.Builder<Builder> {
        /**
         * Intermediate step: the fully qualified name can now be computed, because all
         * parameters are known.
         *
         * @return the builder
         */
        @Fluent
        Builder commitParameters();

        void commit();

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

