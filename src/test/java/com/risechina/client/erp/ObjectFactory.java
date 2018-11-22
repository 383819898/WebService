
package com.risechina.client.erp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.risechina.client.erp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAesSeedResponse_QNAME = new QName("http://erp.risechina.com/", "getAesSeedResponse");
    private final static QName _GetAesSeed_QNAME = new QName("http://erp.risechina.com/", "getAesSeed");
    private final static QName _RequestBank_QNAME = new QName("http://erp.risechina.com/", "requestBank");
    private final static QName _RequestBankResponse_QNAME = new QName("http://erp.risechina.com/", "requestBankResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.risechina.client.erp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAesSeedResponse }
     * 
     */
    public GetAesSeedResponse createGetAesSeedResponse() {
        return new GetAesSeedResponse();
    }

    /**
     * Create an instance of {@link GetAesSeed }
     * 
     */
    public GetAesSeed createGetAesSeed() {
        return new GetAesSeed();
    }

    /**
     * Create an instance of {@link RequestBank }
     * 
     */
    public RequestBank createRequestBank() {
        return new RequestBank();
    }

    /**
     * Create an instance of {@link RequestBankResponse }
     * 
     */
    public RequestBankResponse createRequestBankResponse() {
        return new RequestBankResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAesSeedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.risechina.com/", name = "getAesSeedResponse")
    public JAXBElement<GetAesSeedResponse> createGetAesSeedResponse(GetAesSeedResponse value) {
        return new JAXBElement<GetAesSeedResponse>(_GetAesSeedResponse_QNAME, GetAesSeedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAesSeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.risechina.com/", name = "getAesSeed")
    public JAXBElement<GetAesSeed> createGetAesSeed(GetAesSeed value) {
        return new JAXBElement<GetAesSeed>(_GetAesSeed_QNAME, GetAesSeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestBank }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.risechina.com/", name = "requestBank")
    public JAXBElement<RequestBank> createRequestBank(RequestBank value) {
        return new JAXBElement<RequestBank>(_RequestBank_QNAME, RequestBank.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestBankResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.risechina.com/", name = "requestBankResponse")
    public JAXBElement<RequestBankResponse> createRequestBankResponse(RequestBankResponse value) {
        return new JAXBElement<RequestBankResponse>(_RequestBankResponse_QNAME, RequestBankResponse.class, null, value);
    }

}
