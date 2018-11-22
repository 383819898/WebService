package com.risechina.inter.impl;

import com.risechina.inter.BankTransaction_1;

import javax.jws.WebService;

@WebService(targetNamespace="http://services2/")
public class BankTransactionIMplementation_1 implements BankTransaction_1 {
    @Override
    public String getAesSeed(String sid)
    {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String synAesSeed(String sid, String seed)
    {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String requestBank(String sid, String xml)
    {
        // TODO Auto-generated method stub
        return null;
    }
}