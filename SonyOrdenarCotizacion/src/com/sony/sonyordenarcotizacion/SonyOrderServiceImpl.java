
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.sony.sonyordenarcotizacion;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-04-30T18:35:26.502-05:00
 * Generated source version: 2.7.18
 * 
 */

@javax.jws.WebService(
                      serviceName = "SonyOrdenarCotizacion",
                      portName = "SonyOrderService",
                      targetNamespace = "http://www.sony.com/SonyOrdenarCotizacion/",
                      wsdlLocation = "file:/C:/WorkSpaceKall/SonyOrdenarCotizacion/WebContent/SonyOrdenarCotizacion.wsdl",
                      endpointInterface = "com.sony.sonyordenarcotizacion.SonyOrderService")
                      
public class SonyOrderServiceImpl implements SonyOrderService {

    private static final Logger LOG = Logger.getLogger(SonyOrderServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see com.sony.sonyordenarcotizacion.SonyOrderService#orderQuoute(com.sony.sonyordenarcotizacion.OrderQuouteElement  parameters )*
     */
    public com.sony.sonyordenarcotizacion.OrderQuouteResponseElement orderQuoute(OrderQuouteElement parameters) { 
        LOG.info("Executing operation orderQuoute");
        System.out.println(parameters);
        try {
            com.sony.sonyordenarcotizacion.OrderQuouteResponseElement _return = new com.sony.sonyordenarcotizacion.OrderQuouteResponseElement();
            _return.setResult(false);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}