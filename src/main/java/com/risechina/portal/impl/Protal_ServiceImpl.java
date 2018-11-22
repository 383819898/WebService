package com.risechina.portal.impl;

import com.risechina.portal.Protal_Service;

import javax.jws.WebService;

@WebService(targetNamespace="http://Protal_Services/")
public class Protal_ServiceImpl implements Protal_Service {

/*    @Override
    public String getAesSeed(String code) {
        return "测试成功code："+code;
    }
    */
    @Override
    public String getAesSeed(String code) {
        return null;
    }

    @Override
    public String requestBank(String code, String json) {
        return "测试成功code："+code+",json="+json;
    }
}
