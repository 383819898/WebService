package com.risechina.erp.impl;

import com.risechina.erp.ERP_Service;

import javax.xml.ws.Endpoint;

public class test {

    public static void main(String[] args) {

/*        ERP_Service erp_service= new  ERP_ServiceImpl();

        erp_service.getAesSeed("---------------");*/
        String address="http://localhost:8000/hellow";
        ERP_ServiceImpl hellow = new ERP_ServiceImpl();
        Endpoint.publish(address, hellow);

    }
}
