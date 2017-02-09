//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Email address type (Currently restricted to Internet format user@server.ext.).
 * <p>
 * <p>Java class for EmailType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="EmailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}InternetEmail"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}EmailTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}EffectivePeriod" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmailType", propOrder = {
        "internetEmail",
        "emailTypeCode",
        "effectivePeriod"
})
public class EmailType {

    @XmlElement(name = "InternetEmail", required = true)
    protected String internetEmail;
    @XmlElement(name = "EmailTypeCode")
    protected CodeValueType emailTypeCode;
    @XmlElement(name = "EffectivePeriod")
    protected DateType effectivePeriod;

    /**
     * The email address express as a string (restricted to the Internet format).
     *
     * @return possible object is
     * {@link String }
     */
    public String getInternetEmail() {
        return internetEmail;
    }

    /**
     * Sets the value of the internetEmail property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInternetEmail(String value) {
        this.internetEmail = value;
    }

    /**
     * Code indicating the type of e-mail address. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getEmailTypeCode() {
        return emailTypeCode;
    }

    /**
     * Sets the value of the emailTypeCode property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setEmailTypeCode(CodeValueType value) {
        this.emailTypeCode = value;
    }

    /**
     * Clarifies when the identification information is accurate.
     *
     * @return possible object is
     * {@link DateType }
     */
    public DateType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Sets the value of the effectivePeriod property.
     *
     * @param value allowed object is
     *              {@link DateType }
     */
    public void setEffectivePeriod(DateType value) {
        this.effectivePeriod = value;
    }

}
