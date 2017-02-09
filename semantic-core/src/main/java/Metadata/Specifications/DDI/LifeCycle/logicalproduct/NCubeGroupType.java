//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.logicalproduct;

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
 * Contains a group of NCubes, which may be ordered or hierarchical. In addition to the name, label, and description of the group, the structure allows for defining the type of group using an optional controlled vocabulary, a reference to a defining universe or concept for the group, and a listing of NCubes and NCubeGroups in any order.
 * <p>
 * <p>Java class for NCubeGroupType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="NCubeGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}TypeOfNCubeGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}NCubeGroupName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}NCubeReference"/&gt;
 *           &lt;element ref="{ddi:logicalproduct:3_2}NCubeGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isOrdered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NCubeGroupType", propOrder = {
        "typeOfNCubeGroup",
        "nCubeGroupName",
        "label",
        "description",
        "universeReference",
        "conceptReference",
        "subject",
        "keyword",
        "nCubeReferenceOrNCubeGroupReference"
})
public class NCubeGroupType
        extends VersionableType {

    @XmlElement(name = "TypeOfNCubeGroup")
    protected CodeValueType typeOfNCubeGroup;
    @XmlElement(name = "NCubeGroupName")
    protected List<NameType> nCubeGroupName;
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
            @XmlElementRef(name = "NCubeReference", namespace = "ddi:reusable:3_2", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "NCubeGroupReference", namespace = "ddi:logicalproduct:3_2", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<ReferenceType>> nCubeReferenceOrNCubeGroupReference;
    @XmlAttribute(name = "isOrdered")
    protected Boolean isOrdered;

    /**
     * A brief textual identification of the group type. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfNCubeGroup() {
        return typeOfNCubeGroup;
    }

    /**
     * Sets the value of the typeOfNCubeGroup property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfNCubeGroup(CodeValueType value) {
        this.typeOfNCubeGroup = value;
    }

    /**
     * A name for the group. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the nCubeGroupName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nCubeGroupName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNCubeGroupName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getNCubeGroupName() {
        if (nCubeGroupName == null) {
            nCubeGroupName = new ArrayList<NameType>();
        }
        return this.nCubeGroupName;
    }

    /**
     * A display label for the NCube group. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the NCubeGroup. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to the universe statement describing the persons or other objects to which the contents of this NCube group pertain.Gets the value of the universeReference property.
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
     * Reference to the concept expressed by the NCubes in this group.
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
     * Gets the value of the nCubeReferenceOrNCubeGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nCubeReferenceOrNCubeGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNCubeReferenceOrNCubeGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    public List<JAXBElement<ReferenceType>> getNCubeReferenceOrNCubeGroupReference() {
        if (nCubeReferenceOrNCubeGroupReference == null) {
            nCubeReferenceOrNCubeGroupReference = new ArrayList<JAXBElement<ReferenceType>>();
        }
        return this.nCubeReferenceOrNCubeGroupReference;
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
