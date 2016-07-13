package com.ricky.designpattern.builder;


import com.ricky.designpattern.builder.ch4.Message;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 13:22
 */
public class MessageDemo {

    public static void main(String[] args){

        //1.
        Message message = new Message.Builder()
                .setBusinessCode("yrd")
                .setMessage("hello world")
                .setTimeout(1000)
                .build();

        System.out.println(message);

        //2.
        message = Message.custom()
                .setBusinessCode("yrd")
                .setMessage("hello world")
                .setTimeout(1000)
                .build();

        System.out.println(message);
    }
}
