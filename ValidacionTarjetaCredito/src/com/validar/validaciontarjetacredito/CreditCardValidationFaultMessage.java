
package com.validar.validaciontarjetacredito;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-04-30T11:29:10.765-05:00
 * Generated source version: 2.7.18
 */

@WebFault(name = "error", targetNamespace = "http://www.validar.com/ValidacionTarjetaCredito/")
public class CreditCardValidationFaultMessage extends Exception {
    
    private java.lang.String error;

    public CreditCardValidationFaultMessage() {
        super();
    }
    
    public CreditCardValidationFaultMessage(String message) {
        super(message);
    }
    
    public CreditCardValidationFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditCardValidationFaultMessage(String message, java.lang.String error) {
        super(message);
        this.error = error;
    }

    public CreditCardValidationFaultMessage(String message, java.lang.String error, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public java.lang.String getFaultInfo() {
        return this.error;
    }
}
