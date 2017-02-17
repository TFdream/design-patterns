package com.bytebeats.pattern.builder.ch5;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 13:19
 */
public class Request {
    private final String url;
    private final Map<String, String> headers;

    Request(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public String header(String name) {
        return headers.get(name);
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder {
        private String url;
        private Map<String, String> headers = new HashMap<>();

        public Builder url(String url) {
            this.url = url;
            return this;
        }
        public Builder addHeader(String name, String value) {
            this.headers.put(name, value);
            return this;
        }

        public Builder header(String name, String value) {
            this.headers.put(name, value);
            return this;
        }

        public Request build() {

            return new Request(this.url, headers);
        }

    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", headers=" + headers +
                '}';
    }
}

