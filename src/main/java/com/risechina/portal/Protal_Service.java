package com.risechina.portal;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="Protal_Service")//@WebService：将该接口发布成WebService服务器
public interface Protal_Service {
    public String getAesSeed(@WebParam(name = "code") String code);
    public String requestBank(@WebParam(name = "code") String code, @WebParam(name = "json") String json);
}

