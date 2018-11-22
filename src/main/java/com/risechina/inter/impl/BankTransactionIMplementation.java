package com.risechina.inter.impl;

import com.risechina.inter.BankTransaction;

import javax.jws.WebService;
@WebService(targetNamespace="http://services1/")
public class BankTransactionIMplementation implements BankTransaction {
    @Override
    public String getAesSeed(String sid)
    {
        // TODO Auto-generated method stub
        return "请求成功：sid="+sid;
    }
    @Override
    public String synAesSeed(String sid, String seed)
    {
        // TODO Auto-generated method stub
        return "请求成功：sid="+sid+",seed="+seed;
    }
    @Override
    public String requestBank(String sid, String xml)
    {
        // TODO Auto-generated method stub
        return "请求成功：sid="+sid+",xml="+xml;
    }
}