package com.github.pavelkv96.hw_12102017.http;

/**
 * Created by Pavel on 19.10.2017.
 */

public class Response {
    private String text;
    private int code;

    public Response() {
    }

    public Response(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
