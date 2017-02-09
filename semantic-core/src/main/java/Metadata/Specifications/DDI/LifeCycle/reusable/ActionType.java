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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the region of an image, recording, or text where an action where a specified action is performed and the type of action taken (i.e., Mark an "X" where the actor should be standing on the picture of the stage.).
 * <p>
 * <p>Java class for ActionType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}RegionOfAction" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="regExp" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionType", propOrder = {
        "regionOfAction",
        "description"
})
public class ActionType {

    @XmlElement(name = "RegionOfAction")
    protected SegmentType regionOfAction;
    @XmlElement(name = "Description")
    protected StructuredStringType description;
    @XmlAttribute(name = "regExp")
    protected String regExp;

    /**
     * Identifies the region of the object where the action needs to occur based on the object type by specifying a segment of the object.
     *
     * @return possible object is
     * {@link SegmentType }
     */
    public SegmentType getRegionOfAction() {
        return regionOfAction;
    }

    /**
     * Sets the value of the regionOfAction property.
     *
     * @param value allowed object is
     *              {@link SegmentType }
     */
    public void setRegionOfAction(SegmentType value) {
        this.regionOfAction = value;
    }

    /**
     * Describes the specific actions that should take place. May be expressed in multiple languages and supports the use of structured content.
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
