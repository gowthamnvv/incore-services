//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.datacollection.CellLabelType;


/**
 * A structured display label for the element. Label provides display content of a fully human readable display for the identification of the element. DDI does not impose any length limitations on Label. If length of Label is constrained due to use of the element in a specific application, the maximum length supported should be noted in the attribute maxLength. TypeOfLabel should be used to indicate the application either directly or as an identified type, such as �systems with an 8 character label length limitation�. The label may also indicate its applicability to a specific locale using the attribute locationVariant. Label may be repeated to provide content for different uses or situations. Language variants should be made within the Label using the internal structure of the Structured String type. The assumption is that replication of Label is done to provide different intellectual content or content specific to differing systems or applications.
 * <p>
 * <p>Java class for LabelType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="LabelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}StructuredStringType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeOfLabel" type="{ddi:reusable:3_2}CodeValueType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="locationVariant" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="validForStartDate" type="{ddi:reusable:3_2}BaseDateType" /&gt;
 *       &lt;attribute name="validForEndDate" type="{ddi:reusable:3_2}BaseDateType" /&gt;
 *       &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LabelType", propOrder = {
        "typeOfLabel"
})
@XmlSeeAlso({
        CellLabelType.class
})
public class LabelType
        extends StructuredStringType {

    @XmlElement(name = "TypeOfLabel")
    protected CodeValueType typeOfLabel;
    @XmlAttribute(name = "locationVariant")
    protected String locationVariant;
    @XmlAttribute(name = "validForStartDate")
    protected String validForStartDate;
    @XmlAttribute(name = "validForEndDate")
    protected String validForEndDate;
    @XmlAttribute(name = "maxLength")
    protected BigInteger maxLength;

    /**
     * Gets the value of the typeOfLabel property.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfLabel() {
        return typeOfLabel;
    }

    /**
     * Sets the value of the typeOfLabel property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfLabel(CodeValueType value) {
        this.typeOfLabel = value;
    }

    /**
     * Gets the value of the locationVariant property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLocationVariant() {
        return locationVariant;
    }

    /**
     * Sets the value of the locationVariant property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocationVariant(String value) {
        this.locationVariant = value;
    }

    /**
     * Gets the value of the validForStartDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValidForStartDate() {
        return validForStartDate;
    }

    /**
     * Sets the value of the validForStartDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValidForStartDate(String value) {
        this.validForStartDate = value;
    }

    /**
     * Gets the value of the validForEndDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValidForEndDate() {
        return validForEndDate;
    }

    /**
     * Sets the value of the validForEndDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValidForEndDate(String value) {
        this.validForEndDate = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

}
