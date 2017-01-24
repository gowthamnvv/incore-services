//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.datacollection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CitationType;


/**
 * A citation or URI for the source of the data. Note that this is an external reference, and should not be used to point to DDI descriptions of the data, or to DDI-encoded data.
 * <p>
 * <p>Java class for OriginType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="OriginType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Citation" minOccurs="0"/&gt;
 *         &lt;element name="OriginLocation" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginType", propOrder = {
        "citation",
        "originLocation"
})
public class OriginType {

    @XmlElement(name = "Citation", namespace = "ddi:reusable:3_2")
    protected CitationType citation;
    @XmlElement(name = "OriginLocation")
    @XmlSchemaType(name = "anyURI")
    protected String originLocation;

    /**
     * Citation for the data source.
     *
     * @return possible object is
     * {@link CitationType }
     */
    public CitationType getCitation() {
        return citation;
    }

    /**
     * Sets the value of the citation property.
     *
     * @param value allowed object is
     *              {@link CitationType }
     */
    public void setCitation(CitationType value) {
        this.citation = value;
    }

    /**
     * Gets the value of the originLocation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOriginLocation() {
        return originLocation;
    }

    /**
     * Sets the value of the originLocation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOriginLocation(String value) {
        this.originLocation = value;
    }

}
