package com.risechina.cos;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="COS_Service")//@WebService：将该接口发布成WebService服务器
public interface COS_Service {
    public String getAesSeed(@WebParam(name = "code") String code);
    public String requestBank(@WebParam(name = "code") String code, @WebParam(name = "json") String json);
}

