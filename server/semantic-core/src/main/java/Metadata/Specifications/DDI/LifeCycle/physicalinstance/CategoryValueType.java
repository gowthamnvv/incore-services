//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicalinstance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ValueType;


/**
 * A category value for which one or more statistics are recorded. Each VariableCategory has one category value and any number of associated statistics.
 * <p>
 * <p>Java class for CategoryValueType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CategoryValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{ddi:reusable:3_2}CodeReference"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}ValueRange"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryValueType", propOrder = {
        "codeReference",
        "value"
})
public class CategoryValueType {

    @XmlElement(name = "CodeReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType codeReference;
    @XmlElement(name = "ValueRange", namespace = "ddi:reusable:3_2")
    protected ValueType value;

    /**
     * A reference to the coded value of the category as used by a CodeRepresentation.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getCodeReference() {
        return codeReference;
    }

    /**
     * Sets the value of the codeReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setCodeReference(ReferenceType value) {
        this.codeReference = value;
    }

    /**
     * The value of the category.
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