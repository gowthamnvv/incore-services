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
 * An identifier whose scope of uniqueness is broader than the local archive. Common forms of an international identifier are ISBN, ISSN, DOI or similar designator. Provides both the value of the identifier and the agency who manages it.
 * <p>
 * <p>Java class for InternationalIdentifierType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="InternationalIdentifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}IdentifierContent"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ManagingAgency"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalIdentifierType", propOrder = {
        "identifierContent",
        "managingAgency"
})
public class InternationalIdentifierType {

    @XmlElement(name = "IdentifierContent", required = true)
    protected String identifierContent;
    @XmlElement(name = "ManagingAgency", required = true)
    protected CodeValueType managingAgency;

    /**
     * An identifier as it should be listed for identification purposes.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdentifierContent() {
        return identifierContent;
    }

    /**
     * Sets the value of the identifierContent property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdentifierContent(String value) {
        this.identifierContent = value;
    }

    /**
     * The identification of the Agency which assigns and manages the identifier, i.e., ISBN, ISSN, DOI, etc.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getManagingAgency() {
        return managingAgency;
    }

    /**
     * Sets the value of the managingAgency property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setManagingAgency(CodeValueType value) {
        this.managingAgency = value;
    }

}
