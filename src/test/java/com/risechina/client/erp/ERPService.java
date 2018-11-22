
package com.risechina.client.erp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ERP_Service", targetNamespace = "http://erp.risechina.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ERPService {


    /**
     * 
     * @param code
     * @param json
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestBank", targetNamespace = "http://erp.risechina.com/", className = "com.risechina.client.erp.RequestBank")
    @ResponseWrapper(localName = "requestBankResponse", targetNamespace = "http://erp.risechina.com/", className = "com.risechina.client.erp.RequestBankResponse")
    public String requestBank(
        @WebParam(name = "code", targetNamespace = "")
        String code,
        @WebParam(name = "json", targetNamespace = "")
        String json);

    /**
     * 
     * @param code
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAesSeed", targetNamespace = "http://erp.risechina.com/", className = "com.risechina.client.erp.GetAesSeed")
    @ResponseWrapper(localName = "getAesSeedResponse", targetNamespace = "http://erp.risechina.com/", className = "com.risechina.client.erp.GetAesSeedResponse")
    public String getAesSeed(
        @WebParam(name = "code", targetNamespace = "")
        String code);

}