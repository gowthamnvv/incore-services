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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Structures a textual representation. MinLength and maxlength attributes are inclusive integers describing the number of permitted characters. The regExp attribute holds a regular expression describing the valid contents of the string.
 * <p>
 * <p>Java class for TextRepresentationBaseType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="TextRepresentationBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}RepresentationType"&gt;
 *       &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="minLength" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="regExp" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextRepresentationBaseType")
@XmlSeeAlso({
        TextDomainType.class
})
public class TextRepresentationBaseType
        extends RepresentationType {

    @XmlAttribute(name = "maxLength")
    protected BigInteger maxLength;
    @XmlAttribute(name = "minLength")
    protected BigInteger minLength;
    @XmlAttribute(name = "regExp")
    protected String regExp;

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

    /**
     * Gets the value of the minLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the regExp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegExp() {
        return regExp;
    }

    /**
     * Sets the value of the regExp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegExp(String value) {
        this.regExp = value;
    }

}