//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.logicalproduct;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CoverageType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.MaintainableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.OtherMaterialType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * This is an abstract structure which serves as a substitution base for current and future LogicalProduct definitions relating to specific data types. Used as an extension base for all other LogicalProducts within its substitution group, it ensures that all DDI LogicalProduct descriptions will contain a consistent means of linking a physical data file to its logical (intellectual) description via the LogicalRecord found in DataRelationship. The extension base includes the standard name, label, and description, coverage information, a structure to define data relationships (identifies each logical record and the relationship(s) between them), as well as OtherMaterial related to its contents.
 * <p>
 * <p>Java class for BaseLogicalProductType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="BaseLogicalProductType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}MaintainableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}LogicalProductName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Coverage" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:logicalproduct:3_2}DataRelationship"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}DataRelationshipReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{ddi:reusable:3_2}OtherMaterial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseLogicalProductType", propOrder = {
        "logicalProductName",
        "label",
        "description",
        "coverage",
        "dataRelationshipOrDataRelationshipReference",
        "otherMaterial"
})
@XmlSeeAlso({
        LogicalProductType.class
})
public abstract class BaseLogicalProductType
        extends MaintainableType {

    @XmlElement(name = "LogicalProductName")
    protected List<NameType> logicalProductName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "Coverage", namespace = "ddi:reusable:3_2")
    protected CoverageType coverage;
    @XmlElements({
            @XmlElement(name = "DataRelationship", type = DataRelationshipType.class),
            @XmlElement(name = "DataRelationshipReference", namespace = "ddi:reusable:3_2", type = ReferenceType.class)
    })
    protected List<Object> dataRelationshipOrDataRelationshipReference;
    @XmlElement(name = "OtherMaterial", namespace = "ddi:reusable:3_2")
    protected List<OtherMaterialType> otherMaterial;

    /**
     * A name for the LogicalProduct. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the logicalProductName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalProductName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalProductName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getLogicalProductName() {
        if (logicalProductName == null) {
            logicalProductName = new ArrayList<NameType>();
        }
        return this.logicalProductName;
    }

    /**
     * A display label for the LogicalProduct. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the LogicalProduct. May be expressed in multiple languages and supports the use of structured content.
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
     * The Coverage statement at this level may be used to restrict the coverage described in the StudyUnit module. For example if this specific logical product from a population and housing census only covers housing questions or only provides State and County level data these should be noted here. If there are no changes in the coverage from the coverage of the StudyUnit module, no entry is needed here.
     *
     * @return possible object is
     * {@link CoverageType }
     */
    public CoverageType getCoverage() {
        return coverage;
    }

    /**
     * Sets the value of the coverage property.
     *
     * @param value allowed object is
     *              {@link CoverageType }
     */
    public void setCoverage(CoverageType value) {
        this.coverage = value;
    }

    /**
     * Gets the value of the dataRelationshipOrDataRelationshipReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataRelationshipOrDataRelationshipReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataRelationshipOrDataRelationshipReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataRelationshipType }
     * {@link ReferenceType }
     */
    public List<Object> getDataRelationshipOrDataRelationshipReference() {
        if (dataRelationshipOrDataRelationshipReference == null) {
            dataRelationshipOrDataRelationshipReference = new ArrayList<Object>();
        }
        return this.dataRelationshipOrDataRelationshipReference;
    }

    /**
     * Describes Other Materials that have a specific relation to the logical product. For example the printed data dictionary or printed output for the logical product.Gets the value of the otherMaterial property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherMaterial property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherMaterial().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherMaterialType }
     */
    public List<OtherMaterialType> getOtherMaterial() {
        if (otherMaterial == null) {
            otherMaterial = new ArrayList<OtherMaterialType>();
        }
        return this.otherMaterial;
    }

}