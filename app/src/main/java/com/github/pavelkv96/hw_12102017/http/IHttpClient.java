package com.github.pavelkv96.hw_12102017.http;

/**
 * Created by Pavel on 19.10.2017.
 */

public interface IHttpClient {
    Response doGet(final String url, final String... params);

    Response doPost(final String url, final String body, final String... params);
}
