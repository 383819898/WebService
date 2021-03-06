package com.risechina.inter;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="BankTransaction_1")//@WebService：将该接口发布成WebService服务器
public interface BankTransaction_1 {
    public String getAesSeed(@WebParam(name = "sid") String sid);
    public String synAesSeed(@WebParam(name = "sid") String sid, @WebParam(name = "seed") String seed);
    public String requestBank(@WebParam(name = "sid") String sid, @WebParam(name = "xml") String xml);
}
