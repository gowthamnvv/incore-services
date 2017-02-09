//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Defines the delimiter used to separate variables in a delimited record. Valid values include, space, tab, comma, semicolon, colon, pipe, and other. If "other" is used the characters used for separating (delimiting) objects should be entered in the attribute otherValue. Spaces and binary characters are not allowed. The attribute treatConsecutiveDelimiterAsOne indicates how consecutive delimiters should be handed by the software. The default value of "false" indicates that each delimiter should be treated as a valid delimiter.
 * <p>
 * <p>Java class for DelimiterType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DelimiterType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;ddi:reusable:3_2&gt;SpecifiedDelimiterType"&gt;
 *       &lt;attribute name="otherValue" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="treatConsecutiveDelimiterAsOne" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelimiterType", propOrder = {
        "value"
})
public class DelimiterType {

    @XmlValue
    protected SpecifiedDelimiterType value;
    @XmlAttribute(name = "otherValue")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String otherValue;
    @XmlAttribute(name = "treatConsecutiveDelimiterAsOne")
    protected Boolean treatConsecutiveDelimiterAsOne;

    /**
     * Defines the delimiter used to separate variables in a delimited record. Valid values include, space, tab, comma, semicolon, colon, pipe, and other.
     *
     * @return possible object is
     * {@link SpecifiedDelimiterType }
     */
    public SpecifiedDelimiterType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link SpecifiedDelimiterType }
     */
    public void setValue(SpecifiedDelimiterType value) {
        this.value = value;
    }

    /**
     * Gets the value of the otherValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOtherValue() {
        return otherValue;
    }

    /**
     * Sets the value of the otherValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOtherValue(String value) {
        this.otherValue = value;
    }

    /**
     * Gets the value of the treatConsecutiveDelimiterAsOne property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isTreatConsecutiveDelimiterAsOne() {
        if (treatConsecutiveDelimiterAsOne == null) {
            return false;
        } else {
            return treatConsecutiveDelimiterAsOne;
        }
    }

    /**
     * Sets the value of the treatConsecutiveDelimiterAsOne property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setTreatConsecutiveDelimiterAsOne(Boolean value) {
        this.treatConsecutiveDelimiterAsOne = value;
    }

}
