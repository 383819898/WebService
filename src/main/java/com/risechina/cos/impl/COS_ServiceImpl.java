package com.risechina.cos.impl;

import com.risechina.cos.COS_Service;

import javax.jws.WebService;

@WebService(targetNamespace="http://COS_Services/")
public class COS_ServiceImpl implements COS_Service {

    @Override
    public String getAesSeed(String code) {
        return "测试成功code："+code;
    }

    @Override
    public String requestBank(String code, String json) {
        return "测试成功code："+code+",json="+json;
    }
}
