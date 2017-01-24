//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.archive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A web site URL
 * <p>
 * <p>Java class for URLType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="URLType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;anyURI"&gt;
 *       &lt;attGroup ref="{ddi:archive:3_2}PRIVACY"/&gt;
 *       &lt;attribute name="isPreferred" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "URLType", propOrder = {
        "value"
})
public class URLType {

    @XmlValue
    @XmlSchemaType(name = "anyURI")
    protected String value;
    @XmlAttribute(name = "isPreferred")
    protected Boolean isPreferred;
    @XmlAttribute(name = "privacy")
    protected String privacy;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the isPreferred property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsPreferred() {
        return isPreferred;
    }

    /**
     * Sets the value of the isPreferred property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsPreferred(Boolean value) {
        this.isPreferred = value;
    }

    /**
     * Gets the value of the privacy property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets the value of the privacy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrivacy(String value) {
        this.privacy = value;
    }

}
