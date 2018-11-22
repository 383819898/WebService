package com.risechina.erp.impl;

import javax.jws.WebService;

@WebService(targetNamespace="http://com.risechina.erp.ERP_Service/")
public class ERP_ServiceImpl implements com.risechina.erp.ERP_Service {

    @Override
    public String getAesSeed(String code) {

        System.out.println("=================");
        return "测试成功code："+code;
    }

    @Override
    public String requestBank(String code, String json) {
        return "测试成功code："+code+",json="+json;
    }
}
