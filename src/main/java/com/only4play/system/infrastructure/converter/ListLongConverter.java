package com.only4play.system.infrastructure.converter;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.assertj.core.util.Streams;

public class ListLongConverter implements AttributeConverter<List<Long>, String> {

    @Override
    public String convertToDatabaseColumn(List<Long> longs) {
        return Joiner.on(",").join(longs);
    }

    @Override
    public List<Long> convertToEntityAttribute(String str) {
        return Streams.stream(Splitter.on(",").split(str))
                .map(s -> Long.valueOf(s))
                .collect(Collectors.toList());
    }
}
