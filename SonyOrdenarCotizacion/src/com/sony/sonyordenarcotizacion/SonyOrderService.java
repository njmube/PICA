package com.sony.sonyordenarcotizacion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-04-30T18:35:27.130-05:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://www.sony.com/SonyOrdenarCotizacion/", name = "SonyOrderService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SonyOrderService {

    @WebMethod(action = "http://www.sony.com/SonyOrdenarCotizacion")
    @WebResult(name = "orderQuouteResponseElement", targetNamespace = "http://www.sony.com/SonyOrdenarCotizacion/", partName = "parameters")
    public OrderQuouteResponseElement orderQuoute(
        @WebParam(partName = "parameters", name = "orderQuouteElement", targetNamespace = "http://www.sony.com/SonyOrdenarCotizacion/")
        OrderQuouteElement parameters
    );
}