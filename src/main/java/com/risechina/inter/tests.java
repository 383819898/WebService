package com.risechina.inter;

import com.risechina.erp.impl.ERP_ServiceImpl;

import javax.jws.WebService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class tests {


    public String getAesSeed(String code) {

        System.out.println("=================");
        return "测试成功code："+code;
    }


    public String requestBank(String code, String json) {
        return "测试成功code："+code+",json="+json;
    }
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/erp_servicess", new ERP_ServiceImpl());
        System.out.println("Service success!");
    }

}
