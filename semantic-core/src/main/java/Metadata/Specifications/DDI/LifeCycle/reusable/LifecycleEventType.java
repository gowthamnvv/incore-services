//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Documents an event in the life cycle of a study or group of studies. A life cycle event can be any event which is judged to be significant enough to document by the agency maintaining the documentation for a particular set of data. The element EventType indicates the type of event, using a typology meaningful to the documenter.
 * <p>
 * <p>Java class for LifecycleEventType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="LifecycleEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}IdentifiableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}EventType" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Date" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}AgencyOrganizationReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Relationship" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LifecycleEventType", propOrder = {
        "label",
        "eventType",
        "date",
        "agencyOrganizationReference",
        "description",
        "relationship"
})
public class LifecycleEventType
        extends IdentifiableType {

    @XmlElement(name = "Label")
    protected List<LabelType> label;
    @XmlElement(name = "EventType")
    protected CodeValueType eventType;
    @XmlElement(name = "Date")
    protected DateType date;
    @XmlElement(name = "AgencyOrganizationReference")
    protected List<ReferenceType> agencyOrganizationReference;
    @XmlElement(name = "Description")
    protected StructuredStringType description;
    @XmlElement(name = "Relationship")
    protected List<RelationshipType> relationship;

    /**
     * A label for the Lifecycle Event. May be repeated to provide different labels needed due to system or application constraints.Gets the value of the label property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the label property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabel().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LabelType }
     */
    public List<LabelType> getLabel() {
        if (label == null) {
            label = new ArrayList<LabelType>();
        }
        return this.label;
    }

    /**
     * Indicates the type of event, using a typology meaningful to the documenter. Supports the use of a controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setEventType(CodeValueType value) {
        this.eventType = value;
    }

    /**
     * The date or date range of the lifecycle event.
     *
     * @return possible object is
     * {@link DateType }
     */
    public DateType getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link DateType }
     */
    public void setDate(DateType value) {
        this.date = value;
    }

    /**
     * Reference to an organization or individual, defined in the organization scheme, responsible for the life cycle event.Gets the value of the agencyOrganizationReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agencyOrganizationReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgencyOrganizationReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getAgencyOrganizationReference() {
        if (agencyOrganizationReference == null) {
            agencyOrganizationReference = new ArrayList<ReferenceType>();
        }
        return this.agencyOrganizationReference;
    }

    /**
     * A description of the event such as what the event included, its importance, or other significant information. Structure supports the use of multiple languages.
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
     * Allows linking a lifecycle event to one or more sections of metadata. If no relationship is noted the lifecycle event relates to its full parent StudyUnit, Group, or Resource Package.Gets the value of the relationship property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationship property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationship().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelationshipType }
     */
    public List<RelationshipType> getRelationship() {
        if (relationship == null) {
            relationship = new ArrayList<RelationshipType>();
        }
        return this.relationship;
    }

}
