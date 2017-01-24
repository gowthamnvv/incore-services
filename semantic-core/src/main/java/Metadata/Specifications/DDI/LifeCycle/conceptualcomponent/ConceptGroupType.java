//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.conceptualcomponent;

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
 * Allows for grouping of concepts; groups may have a hierarchical structure. This structure should not be used to model semantic concept hierarchies - for this purpose, use the SubclassOfReference element within Concept.
 * <p>
 * <p>Java class for ConceptGroupType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ConceptGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}TypeOfConceptGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptGroupName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}GroupingUniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}GroupingConceptReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}ConceptReference"/&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isOrdered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="isAdministrativeOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="isConcept" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptGroupType", propOrder = {
        "typeOfConceptGroup",
        "conceptGroupName",
        "label",
        "description",
        "groupingUniverseReference",
        "groupingConceptReference",
        "subject",
        "keyword",
        "conceptReferenceOrConceptGroupReference"
})
public class ConceptGroupType
        extends VersionableType {

    @XmlElement(name = "TypeOfConceptGroup")
    protected CodeValueType typeOfConceptGroup;
    @XmlElement(name = "ConceptGroupName")
    protected List<NameType> conceptGroupName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "GroupingUniverseReference")
    protected List<ReferenceType> groupingUniverseReference;
    @XmlElement(name = "GroupingConceptReference")
    protected ReferenceType groupingConceptReference;
    @XmlElement(name = "Subject", namespace = "ddi:reusable:3_2")
    protected List<InternationalCodeValueType> subject;
    @XmlElement(name = "Keyword", namespace = "ddi:reusable:3_2")
    protected List<InternationalCodeValueType> keyword;
    @XmlElementRefs({
            @XmlElementRef(name = "ConceptReference", namespace = "ddi:reusable:3_2", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "ConceptGroupReference", namespace = "ddi:conceptualcomponent:3_2", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<ReferenceType>> conceptReferenceOrConceptGroupReference;
    @XmlAttribute(name = "isOrdered")
    protected Boolean isOrdered;
    @XmlAttribute(name = "isAdministrativeOnly")
    protected Boolean isAdministrativeOnly;
    @XmlAttribute(name = "isConcept")
    protected Boolean isConcept;

    /**
     * Specifies the purpose of the ConceptGroup. If conceptual the GroupingConceptReference or GroupingUniverseReference should be used to further define the group. The object allows for specification of the purpose using a brief string or term. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfConceptGroup() {
        return typeOfConceptGroup;
    }

    /**
     * Sets the value of the typeOfConceptGroup property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfConceptGroup(CodeValueType value) {
        this.typeOfConceptGroup = value;
    }

    /**
     * A name for the ConceptGroup. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the conceptGroupName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptGroupName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptGroupName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getConceptGroupName() {
        if (conceptGroupName == null) {
            conceptGroupName = new ArrayList<NameType>();
        }
        return this.conceptGroupName;
    }

    /**
     * A display label for the ConceptGroup. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the ConceptGroup. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to the universe statement describing the persons or other objects to which the contents of this group pertain. Note that this is not a formal linking of a concept to a university such as found in a ConceptualVariable. It is a means of helping to define the context within which this ConceptGroup is relevant.Gets the value of the groupingUniverseReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupingUniverseReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupingUniverseReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getGroupingUniverseReference() {
        if (groupingUniverseReference == null) {
            groupingUniverseReference = new ArrayList<ReferenceType>();
        }
        return this.groupingUniverseReference;
    }

    /**
     * Reference to the concept expressed by the objects in this group. Expresses a conceptual basis for grouping the concepts. Note that this is not a formal linking of a concept to a university such as found in a ConceptualVariable. It is a means of helping to define the context within which this ConceptGroup is relevant.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getGroupingConceptReference() {
        return groupingConceptReference;
    }

    /**
     * Sets the value of the groupingConceptReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setGroupingConceptReference(ReferenceType value) {
        this.groupingConceptReference = value;
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
     * Gets the value of the conceptReferenceOrConceptGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptReferenceOrConceptGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptReferenceOrConceptGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    public List<JAXBElement<ReferenceType>> getConceptReferenceOrConceptGroupReference() {
        if (conceptReferenceOrConceptGroupReference == null) {
            conceptReferenceOrConceptGroupReference = new ArrayList<JAXBElement<ReferenceType>>();
        }
        return this.conceptReferenceOrConceptGroupReference;
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

    /**
     * Gets the value of the isAdministrativeOnly property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsAdministrativeOnly() {
        if (isAdministrativeOnly == null) {
            return false;
        } else {
            return isAdministrativeOnly;
        }
    }

    /**
     * Sets the value of the isAdministrativeOnly property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsAdministrativeOnly(Boolean value) {
        this.isAdministrativeOnly = value;
    }

    /**
     * Gets the value of the isConcept property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsConcept() {
        if (isConcept == null) {
            return false;
        } else {
            return isConcept;
        }
    }

    /**
     * Sets the value of the isConcept property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsConcept(Boolean value) {
        this.isConcept = value;
    }

}
