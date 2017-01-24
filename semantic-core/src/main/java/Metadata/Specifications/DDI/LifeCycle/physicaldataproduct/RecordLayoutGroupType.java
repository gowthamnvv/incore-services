//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalCodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * Contains a group of RecordLayout descriptions for administrative or conceptual purposes, which may be hierarchical. In addition to the standard name, label, and description, allows for a classification of the type of group, a reference to a Universe and Concept and inclusion of RecordLayouts and RecordLayoutGroups by reference, plus a flag indicating if the group is ordered.
 * <p>
 * <p>Java class for RecordLayoutGroupType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RecordLayoutGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}TypeOfRecordLayoutGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}RecordLayoutGroupName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}RecordLayoutReference"/&gt;
 *           &lt;element ref="{ddi:physicaldataproduct:3_2}RecordLayoutGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isOrdered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordLayoutGroupType", propOrder = {
        "typeOfRecordLayoutGroup",
        "recordLayoutGroupName",
        "label",
        "description",
        "universeReference",
        "conceptReference",
        "subject",
        "keyword",
        "recordLayoutReferenceOrRecordLayoutGroupReference"
})
public class RecordLayoutGroupType
        extends VersionableType {

    @XmlElement(name = "TypeOfRecordLayoutGroup")
    protected CodeValueType typeOfRecordLayoutGroup;
    @XmlElement(name = "RecordLayoutGroupName")
    protected List<NameType> recordLayoutGroupName;
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
    @XmlElementRefs({
            @XmlElementRef(name = "RecordLayoutGroupReference", namespace = "ddi:physicaldataproduct:3_2", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "RecordLayoutReference", namespace = "ddi:reusable:3_2", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<ReferenceType>> recordLayoutReferenceOrRecordLayoutGroupReference;
    @XmlAttribute(name = "isOrdered")
    protected Boolean isOrdered;

    /**
     * A generic element for specifying a reason for a RecordLayoutGroup. Note that this element can contain either a term from a controlled vocabulary list or a textual description.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfRecordLayoutGroup() {
        return typeOfRecordLayoutGroup;
    }

    /**
     * Sets the value of the typeOfRecordLayoutGroup property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfRecordLayoutGroup(CodeValueType value) {
        this.typeOfRecordLayoutGroup = value;
    }

    /**
     * A name for the RecordLayoutGroup. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the recordLayoutGroupName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordLayoutGroupName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordLayoutGroupName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getRecordLayoutGroupName() {
        if (recordLayoutGroupName == null) {
            recordLayoutGroupName = new ArrayList<NameType>();
        }
        return this.recordLayoutGroupName;
    }

    /**
     * A display label for the RecordLayoutGroup. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the RecordLayoutGroup. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to the universe statement describing the persons or other elements that the data refer to, and to which any analytic results refer.Gets the value of the universeReference property.
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
     * Reference to the concept represented by the record layout in this group.
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
     * Gets the value of the recordLayoutReferenceOrRecordLayoutGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordLayoutReferenceOrRecordLayoutGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordLayoutReferenceOrRecordLayoutGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    public List<JAXBElement<ReferenceType>> getRecordLayoutReferenceOrRecordLayoutGroupReference() {
        if (recordLayoutReferenceOrRecordLayoutGroupReference == null) {
            recordLayoutReferenceOrRecordLayoutGroupReference = new ArrayList<JAXBElement<ReferenceType>>();
        }
        return this.recordLayoutReferenceOrRecordLayoutGroupReference;
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
