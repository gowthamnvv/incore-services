//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.datacollection.NumericDomainType;


/**
 * Defines the representation for a numeric response. May be a range or specific value, or a list of ranges.
 * <p>
 * <p>Java class for NumericRepresentationBaseType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="NumericRepresentationBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}RepresentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}NumberRange" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}NumericTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="scale" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="decimalPositions" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericRepresentationBaseType", propOrder = {
        "numberRange",
        "numericTypeCode"
})
@XmlSeeAlso({
        NumericDomainType.class
})
public class NumericRepresentationBaseType
        extends RepresentationType {

    @XmlElement(name = "NumberRange")
    protected List<NumberRangeType> numberRange;
    @XmlElement(name = "NumericTypeCode")
    protected CodeValueType numericTypeCode;
    @XmlAttribute(name = "format")
    protected String format;
    @XmlAttribute(name = "scale")
    protected BigInteger scale;
    @XmlAttribute(name = "decimalPositions")
    protected BigInteger decimalPositions;
    @XmlAttribute(name = "interval")
    protected BigInteger interval;

    /**
     * Defines the valid number range or number values for the representation.Gets the value of the numberRange property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numberRange property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNumberRange().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumberRangeType }
     */
    public List<NumberRangeType> getNumberRange() {
        if (numberRange == null) {
            numberRange = new ArrayList<NumberRangeType>();
        }
        return this.numberRange;
    }

    /**
     * Identification of the numeric type such as integer, decimal, etc. supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getNumericTypeCode() {
        return numericTypeCode;
    }

    /**
     * Sets the value of the numericTypeCode property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setNumericTypeCode(CodeValueType value) {
        this.numericTypeCode = value;
    }

    /**
     * Gets the value of the format property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the scale property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setScale(BigInteger value) {
        this.scale = value;
    }

    /**
     * Gets the value of the decimalPositions property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getDecimalPositions() {
        return decimalPositions;
    }

    /**
     * Sets the value of the decimalPositions property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setDecimalPositions(BigInteger value) {
        this.decimalPositions = value;
    }

    /**
     * Gets the value of the interval property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setInterval(BigInteger value) {
        this.interval = value;
    }

}
