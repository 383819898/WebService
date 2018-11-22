package com.risechina.erp;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="ERP_Service")//@WebService：将该接口发布成WebService服务器
public interface ERP_Service {
    public String getAesSeed( @WebParam( name="code") String code);
    public String requestBank(@WebParam( name="code") String code, @WebParam(name="json") String json);
}

