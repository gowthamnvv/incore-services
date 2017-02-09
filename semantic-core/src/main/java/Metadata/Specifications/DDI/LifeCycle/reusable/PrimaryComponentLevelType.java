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
 * Provides references to the base level elements that are used as building blocks for composed geographies. For example, Metropolitan areas that are composed of counties except in the New England States where they are composed of county subdivisions, or School Attendance Boundaries (SABINS) built from Census Blocks. This structure allows for specifying the basic building block for composed areas and any restrictions (coverage limitations).
 * <p>
 * <p>Java class for PrimaryComponentLevelType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PrimaryComponentLevelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}GeographicLevelReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}CoverageLimitation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimaryComponentLevelType", propOrder = {
        "geographicLevelReference",
        "coverageLimitation"
})
public class PrimaryComponentLevelType {

    @XmlElement(name = "GeographicLevelReference")
    protected ReferenceType geographicLevelReference;
    @XmlElement(name = "CoverageLimitation")
    protected InternationalStringType coverageLimitation;

    /**
     * Reference to the Geographic Level used as the basic building block to a composite area. Use the largest level that is consistently used in full (i.e. Use a State rather than the sub-level County if a State is always a member of the composed unit in its entirety.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getGeographicLevelReference() {
        return geographicLevelReference;
    }

    /**
     * Sets the value of the geographicLevelReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setGeographicLevelReference(ReferenceType value) {
        this.geographicLevelReference = value;
    }

    /**
     * Describes a limitation of the coverage such as all Metropolitan Areas EXCEPT those in New England States.
     *
     * @return possible object is
     * {@link InternationalStringType }
     */
    public InternationalStringType getCoverageLimitation() {
        return coverageLimitation;
    }

    /**
     * Sets the value of the coverageLimitation property.
     *
     * @param value allowed object is
     *              {@link InternationalStringType }
     */
    public void setCoverageLimitation(InternationalStringType value) {
        this.coverageLimitation = value;
    }

}
