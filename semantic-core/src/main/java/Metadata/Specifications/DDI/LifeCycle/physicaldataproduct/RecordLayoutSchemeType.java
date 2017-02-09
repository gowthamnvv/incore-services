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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.dataset.DataSetType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.MaintainableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.SchemeReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * A scheme containing a set of RecordLayouts describing the location of individual data items within the physical record and how to address them (locate and retrieve). RecordLayouts provide a link to the PhysicalStructure description and to individual variables or NCubes describing the data items.
 * <p>
 * <p>Java class for RecordLayoutSchemeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RecordLayoutSchemeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}MaintainableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}RecordLayoutSchemeName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}RecordLayoutSchemeReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:physicaldataproduct:3_2}BaseRecordLayout"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}RecordLayoutReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:physicaldataproduct:3_2}RecordLayoutGroup"/&gt;
 *           &lt;element ref="{ddi:physicaldataproduct:3_2}RecordLayoutGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordLayoutSchemeType", propOrder = {
        "recordLayoutSchemeName",
        "label",
        "description",
        "recordLayoutSchemeReference",
        "baseRecordLayoutOrRecordLayoutReference",
        "recordLayoutGroupOrRecordLayoutGroupReference"
})
public class RecordLayoutSchemeType
        extends MaintainableType {

    @XmlElement(name = "RecordLayoutSchemeName")
    protected List<NameType> recordLayoutSchemeName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "RecordLayoutSchemeReference", namespace = "ddi:reusable:3_2")
    protected List<SchemeReferenceType> recordLayoutSchemeReference;
    @XmlElementRefs({
            @XmlElementRef(name = "RecordLayoutReference", namespace = "ddi:reusable:3_2", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "BaseRecordLayout", namespace = "ddi:physicaldataproduct:3_2", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> baseRecordLayoutOrRecordLayoutReference;
    @XmlElements({
            @XmlElement(name = "RecordLayoutGroup", type = RecordLayoutGroupType.class),
            @XmlElement(name = "RecordLayoutGroupReference", type = ReferenceType.class)
    })
    protected List<Object> recordLayoutGroupOrRecordLayoutGroupReference;

    /**
     * A name for the RecordLayoutScheme. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the recordLayoutSchemeName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordLayoutSchemeName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordLayoutSchemeName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getRecordLayoutSchemeName() {
        if (recordLayoutSchemeName == null) {
            recordLayoutSchemeName = new ArrayList<NameType>();
        }
        return this.recordLayoutSchemeName;
    }

    /**
     * A display label for the RecordLayoutScheme. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the RecordLayoutScheme. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to an existing RecordLayoutScheme for inclusion.Gets the value of the recordLayoutSchemeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordLayoutSchemeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordLayoutSchemeReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeReferenceType }
     */
    public List<SchemeReferenceType> getRecordLayoutSchemeReference() {
        if (recordLayoutSchemeReference == null) {
            recordLayoutSchemeReference = new ArrayList<SchemeReferenceType>();
        }
        return this.recordLayoutSchemeReference;
    }

    /**
     * Gets the value of the baseRecordLayoutOrRecordLayoutReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseRecordLayoutOrRecordLayoutReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseRecordLayoutOrRecordLayoutReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DDI.physicaldataproduct_proprietary.RecordLayoutType }{@code >}
     * {@link JAXBElement }{@code <}{@link DDI.physicaldataproduct_ncube_tabular.RecordLayoutType }{@code >}
     * {@link JAXBElement }{@code <}{@link DDI.physicaldataproduct.RecordLayoutType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * {@link JAXBElement }{@code <}{@link DDI.physicaldataproduct_ncube_inline.RecordLayoutType }{@code >}
     * {@link JAXBElement }{@code <}{@link DataSetType }{@code >}
     * {@link JAXBElement }{@code <}{@link DDI.physicaldataproduct_ncube_normal.RecordLayoutType }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseRecordLayoutType }{@code >}
     */
    public List<JAXBElement<?>> getBaseRecordLayoutOrRecordLayoutReference() {
        if (baseRecordLayoutOrRecordLayoutReference == null) {
            baseRecordLayoutOrRecordLayoutReference = new ArrayList<JAXBElement<?>>();
        }
        return this.baseRecordLayoutOrRecordLayoutReference;
    }

    /**
     * Gets the value of the recordLayoutGroupOrRecordLayoutGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordLayoutGroupOrRecordLayoutGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordLayoutGroupOrRecordLayoutGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordLayoutGroupType }
     * {@link ReferenceType }
     */
    public List<Object> getRecordLayoutGroupOrRecordLayoutGroupReference() {
        if (recordLayoutGroupOrRecordLayoutGroupReference == null) {
            recordLayoutGroupOrRecordLayoutGroupReference = new ArrayList<Object>();
        }
        return this.recordLayoutGroupOrRecordLayoutGroupReference;
    }

}
