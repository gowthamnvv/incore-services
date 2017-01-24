//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ValueType;


/**
 * Reference to the Unique key variable for segment identification and the value it contains for the specific segment. TypeOfObject should be set to Variable.
 * <p>
 * <p>Java class for KeyVariableReferenceType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="KeyVariableReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}ReferenceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ValueRange"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyVariableReferenceType", propOrder = {
        "value"
})
public class KeyVariableReferenceType
        extends ReferenceType {

    @XmlElement(name = "ValueRange", namespace = "ddi:reusable:3_2", required = true)
    protected ValueType value;

    /**
     * ValueRange of the variable for this segment.
     *
     * @return possible object is
     * {@link ValueType }
     */
    public ValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link ValueType }
     */
    public void setValue(ValueType value) {
        this.value = value;
    }

}
