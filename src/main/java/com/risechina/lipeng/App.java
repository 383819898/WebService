package com.risechina.lipeng;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        String address = "http://127.0.0.1:8099/HelloWorld";
        Endpoint.publish(address, new HelloWorldImpl());
        System.out.println("发布消息成功");
    }
}