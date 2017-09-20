//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.datacollection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalCodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * Contains a group of ControlConstructs, which may describe an ordered or hierarchical relationship structure. Specifies the purpose of the group, a name, label, and description of the group, its relationship to a specific universe or concept, and lists the members of the group.
 * <p>
 * <p>Java class for ControlConstructGroupType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ControlConstructGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}TypeOfControlConstructGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}ControlConstructGroupName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:datacollection:3_2}ControlConstructReference"/&gt;
 *           &lt;element ref="{ddi:datacollection:3_2}ControlConstructGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isOrdered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlConstructGroupType", propOrder = {
        "typeOfControlConstructGroup",
        "controlConstructGroupName",
        "label",
        "description",
        "universeReference",
        "conceptReference",
        "subject",
        "keyword",
        "controlConstructReferenceOrControlConstructGroupReference"
})
public class ControlConstructGroupType
        extends VersionableType {

    @XmlElement(name = "TypeOfControlConstructGroup")
    protected CodeValueType typeOfControlConstructGroup;
    @XmlElement(name = "ControlConstructGroupName")
    protected List<NameType> controlConstructGroupName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "UniverseReference", namespace = "ddi:reusable:3_2")
    protected List<ReferenceType> universeReference;
    @XmlElement(name = "ConceptReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType conceptReference;
    @XmlElement(name = "Subject", namespace = "ddi:reusable:3_2")
    protected List<InternationalCodeValueType> subject;
    @XmlElement(name = "Keyword", namespace = "ddi:reusable:3_2")
    protected List<InternationalCodeValueType> keyword;
    @XmlElements({
            @XmlElement(name = "ControlConstructReference", type = ControlConstructReferenceType.class),
            @XmlElement(name = "ControlConstructGroupReference")
    })
    protected List<ReferenceType> controlConstructReferenceOrControlConstructGroupReference;
    @XmlAttribute(name = "isOrdered")
    protected Boolean isOrdered;

    /**
     * A generic element for specifying a reason for a ControlConstructGroup. Note that this element can contain either a term from a controlled vocabulary list or a textual description.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfControlConstructGroup() {
        return typeOfControlConstructGroup;
    }

    /**
     * Sets the value of the typeOfControlConstructGroup property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfControlConstructGroup(CodeValueType value) {
        this.typeOfControlConstructGroup = value;
    }

    /**
     * A name for the group. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the controlConstructGroupName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlConstructGroupName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlConstructGroupName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getControlConstructGroupName() {
        if (controlConstructGroupName == null) {
            controlConstructGroupName = new ArrayList<NameType>();
        }
        return this.controlConstructGroupName;
    }

    /**
     * A display label for the ControlConstructGroup. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the ControlConstructGroup. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to the universe statement describing the persons or other objects to which the contents of this group pertain.Gets the value of the universeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniverseReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getUniverseReference() {
        if (universeReference == null) {
            universeReference = new ArrayList<ReferenceType>();
        }
        return this.universeReference;
    }

    /**
     * Reference to the concept expressed by the objects in this group.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getConceptReference() {
        return conceptReference;
    }

    /**
     * Sets the value of the conceptReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setConceptReference(ReferenceType value) {
        this.conceptReference = value;
    }

    /**
     * If subjects are listed for this group, it is strongly recommended that the subjects listed also be found in the TopicalCoverage element for the parent packaging element when this group is included directly or by reference in a module containing a coverage element. Use of subject at the group level allows for associating objects as a type of subject based group or to identify subject characteristics of a reusable group of objects.Gets the value of the subject property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalCodeValueType }
     */
    public List<InternationalCodeValueType> getSubject() {
        if (subject == null) {
            subject = new ArrayList<InternationalCodeValueType>();
        }
        return this.subject;
    }

    /**
     * If keywords are listed for this group, it is strongly recommended that the keywords listed also be found in the TopicalCoverage element for the parent packaging element when this group is included directly or by reference in a module containing a coverage element. Use of keyword at the group level allows for associating objects as a type of keyword based group or to identify keyword characteristics of a reusable group of objects.Gets the value of the keyword property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalCodeValueType }
     */
    public List<InternationalCodeValueType> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<InternationalCodeValueType>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the controlConstructReferenceOrControlConstructGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlConstructReferenceOrControlConstructGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlConstructReferenceOrControlConstructGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlConstructReferenceType }
     * {@link ReferenceType }
     */
    public List<ReferenceType> getControlConstructReferenceOrControlConstructGroupReference() {
        if (controlConstructReferenceOrControlConstructGroupReference == null) {
            controlConstructReferenceOrControlConstructGroupReference = new ArrayList<ReferenceType>();
        }
        return this.controlConstructReferenceOrControlConstructGroupReference;
    }

    /**
     * Gets the value of the isOrdered property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsOrdered() {
        if (isOrdered == null) {
            return false;
        } else {
            return isOrdered;
        }
    }

    /**
     * Sets the value of the isOrdered property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsOrdered(Boolean value) {
        this.isOrdered = value;
    }

}