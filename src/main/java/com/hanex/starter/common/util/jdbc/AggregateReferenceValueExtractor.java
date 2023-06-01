package com.hanex.starter.common.util.jdbc;

import org.springframework.data.jdbc.core.mapping.AggregateReference;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

// TODO 해당 class 설정 관련 문서 쓸것
public class AggregateReferenceValueExtractor implements ValueExtractor<AggregateReference<?, @ExtractedValue ?>> {
    public AggregateReferenceValueExtractor() {
    }

    @Override
    public void extractValues(AggregateReference<?, ?> originalValue, ValueReceiver receiver) {
        receiver.value("id", originalValue.getId());
    }
}

