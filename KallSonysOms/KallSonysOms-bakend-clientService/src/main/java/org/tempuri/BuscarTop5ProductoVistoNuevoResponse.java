
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.productoentities.ArrayOfProductoEntity;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BuscarTop5ProductoVistoNuevoResult" type="{http://schemas.datacontract.org/2004/07/ProductoEntities}ArrayOfProductoEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "buscarTop5ProductoVistoNuevoResult"
})
@XmlRootElement(name = "BuscarTop5ProductoVistoNuevoResponse")
public class BuscarTop5ProductoVistoNuevoResponse {

    @XmlElement(name = "BuscarTop5ProductoVistoNuevoResult", nillable = true)
    protected ArrayOfProductoEntity buscarTop5ProductoVistoNuevoResult;

    /**
     * Obtiene el valor de la propiedad buscarTop5ProductoVistoNuevoResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProductoEntity }
     *     
     */
    public ArrayOfProductoEntity getBuscarTop5ProductoVistoNuevoResult() {
        return buscarTop5ProductoVistoNuevoResult;
    }

    /**
     * Define el valor de la propiedad buscarTop5ProductoVistoNuevoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProductoEntity }
     *     
     */
    public void setBuscarTop5ProductoVistoNuevoResult(ArrayOfProductoEntity value) {
        this.buscarTop5ProductoVistoNuevoResult = value;
    }

}
