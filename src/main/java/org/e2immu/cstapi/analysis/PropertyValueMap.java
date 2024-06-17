package org.e2immu.cstapi.analysis;

import java.util.stream.Stream;

public interface PropertyValueMap {

    Property property(String key);

    String decode(Codec codec, Property property, Codec.EncodedValue encodedValue);

    default org.e2immu.cstapi.analysis.Codec.EncodedPropertyValue encode(Codec codec, Property property, Value value) {
        Codec.EncodedValue encodedValue = value.encode(codec);
        return new org.e2immu.cstapi.analysis.Codec.EncodedPropertyValue(property.key(), encodedValue);
    }

    <V extends Value> V getOrDefault(Property property, V defaultValue);

    boolean haveAnalyzedValueFor(Property property);

    <V extends Value> void set(Property property, V value);
}
