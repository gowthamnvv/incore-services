//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.archive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.DateType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * Captures an individuals assigned researcher ID within a specified system. Includes the type or researcher ID provided, the ID, a URI of the location or link, and a description of the researcher ID provided. E.g., Rajiv Agrwal, type=researcherID, ID=A-8725-2008), URI=www.researcherid.com/rid/A-8725-2008 which brings you to the researchers page.
 * <p>
 * <p>Java class for ResearcherIDType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ResearcherIDType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeOfID" type="{ddi:reusable:3_2}CodeValueType" minOccurs="0"/&gt;
 *         &lt;element name="ResearcherIdentification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}URI" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}EffectivePeriod" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResearcherIDType", propOrder = {
        "typeOfID",
        "researcherIdentification",
        "uri",
        "description",
        "effectivePeriod"
})
public class ResearcherIDType {

    @XmlElement(name = "TypeOfID")
    protected CodeValueType typeOfID;
    @XmlElement(name = "ResearcherIdentification")
    protected String researcherIdentification;
    @XmlElement(name = "URI", namespace = "ddi:reusable:3_2")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "EffectivePeriod", namespace = "ddi:reusable:3_2")
    protected DateType effectivePeriod;

    /**
     * Gets the value of the typeOfID property.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfID() {
        return typeOfID;
    }

    /**
     * Sets the value of the typeOfID property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfID(CodeValueType value) {
        this.typeOfID = value;
    }

    /**
     * Gets the value of the researcherIdentification property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResearcherIdentification() {
        return researcherIdentification;
    }

    /**
     * Sets the value of the researcherIdentification property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResearcherIdentification(String value) {
        this.researcherIdentification = value;
    }

    /**
     * The URI (URN or URL) of the of the researcher ID.
     *
     * @return possible object is
     * {@link String }
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURI(String value) {
        this.uri = value;
    }

    /**
     * A description of the purpose and use of the researcher ID. May be expressed in multiple languages and supports the use of structured content.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setDescription(StructuredStringType value) {
        this.description = value;
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
