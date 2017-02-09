//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.conceptualcomponent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.MaintainableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.SchemeReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * Contains a set of Universe descriptions that may be organized into sub-universe structures. A Universe may also be known as a population. A Universe describes the "object" of a Data Element Concept or Data Element as defined by ISO/IEC 11179.
 * <p>
 * <p>Java class for UniverseSchemeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="UniverseSchemeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}MaintainableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}UniverseSchemeName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseSchemeReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}Universe"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}UniverseReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}UniverseGroup"/&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}UniverseGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniverseSchemeType", propOrder = {
        "universeSchemeName",
        "label",
        "description",
        "universeSchemeReference",
        "universeOrUniverseReference",
        "universeGroupOrUniverseGroupReference"
})
public class UniverseSchemeType
        extends MaintainableType {

    @XmlElement(name = "UniverseSchemeName")
    protected List<NameType> universeSchemeName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "UniverseSchemeReference", namespace = "ddi:reusable:3_2")
    protected List<SchemeReferenceType> universeSchemeReference;
    @XmlElements({
            @XmlElement(name = "Universe", type = UniverseType.class),
            @XmlElement(name = "UniverseReference", namespace = "ddi:reusable:3_2", type = ReferenceType.class)
    })
    protected List<Object> universeOrUniverseReference;
    @XmlElements({
            @XmlElement(name = "UniverseGroup", type = UniverseGroupType.class),
            @XmlElement(name = "UniverseGroupReference", type = ReferenceType.class)
    })
    protected List<Object> universeGroupOrUniverseGroupReference;

    /**
     * A name for the UniverseScheme. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the universeSchemeName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universeSchemeName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniverseSchemeName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getUniverseSchemeName() {
        if (universeSchemeName == null) {
            universeSchemeName = new ArrayList<NameType>();
        }
        return this.universeSchemeName;
    }

    /**
     * A display label for the UniverseScheme. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the UniverseScheme. May be expressed in multiple languages and supports the use of structured content.
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
     * Allows the inclusion of a UniverseScheme by reference.Gets the value of the universeSchemeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universeSchemeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniverseSchemeReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeReferenceType }
     */
    public List<SchemeReferenceType> getUniverseSchemeReference() {
        if (universeSchemeReference == null) {
            universeSchemeReference = new ArrayList<SchemeReferenceType>();
        }
        return this.universeSchemeReference;
    }

    /**
     * Gets the value of the universeOrUniverseReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universeOrUniverseReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniverseOrUniverseReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniverseType }
     * {@link ReferenceType }
     */
    public List<Object> getUniverseOrUniverseReference() {
        if (universeOrUniverseReference == null) {
            universeOrUniverseReference = new ArrayList<Object>();
        }
        return this.universeOrUniverseReference;
    }

    /**
     * Gets the value of the universeGroupOrUniverseGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universeGroupOrUniverseGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniverseGroupOrUniverseGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniverseGroupType }
     * {@link ReferenceType }
     */
    public List<Object> getUniverseGroupOrUniverseGroupReference() {
        if (universeGroupOrUniverseGroupReference == null) {
            universeGroupOrUniverseGroupReference = new ArrayList<Object>();
        }
        return this.universeGroupOrUniverseGroupReference;
    }

}
