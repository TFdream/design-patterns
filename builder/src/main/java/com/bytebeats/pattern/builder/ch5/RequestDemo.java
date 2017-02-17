package com.bytebeats.pattern.builder.ch5;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 13:22
 */
public class RequestDemo {

    public static void main(String[] args){

        Request request = new Request.Builder()
                .url("https://api.github.com/repos/square/okhttp/issues")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        System.out.println(request);

        //2.
        Request req = Request.newBuilder()
                .url("http://publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        System.out.println(req);
    }
}
