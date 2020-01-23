package com.RecipeBookBackend.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert Entity to DTO or DTO to Entity
 *
 * @param <F> from
 * @param <T> to
 */
public interface BaseConverter<F, T> {

    T convert(F from);

    default List<T> convertAll(Collection<F> elements) {
        return elements.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
