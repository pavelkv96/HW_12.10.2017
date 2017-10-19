package com.github.pavelkv96.hw_12102017.parser;

import java.util.List;

/**
 * Created by Pavel on 19.10.2017.
 */

public interface Parser<T> {
    T parse(final String string) throws Exception;
    List<T> parseArray(final String string) throws Exception;

    String toJson(T object);
}
