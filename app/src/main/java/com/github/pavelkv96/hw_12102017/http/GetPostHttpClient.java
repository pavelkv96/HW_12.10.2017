package com.github.pavelkv96.hw_12102017.http;

/**
 * Created by Pavel on 19.10.2017.
 */

public class GetPostHttpClient implements IHttpClient{


    @Override
    public Response doGet(String url, String... params) {
        throw new UnsupportedOperationException("doGet");
    }

    @Override
    public Response doPost(String url, String body, String... params) {
        Response result = null;
        try {
            result = new HttpPostAsyncTask().execute(url, body).get();
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }
}
