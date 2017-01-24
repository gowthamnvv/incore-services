//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.logicalproduct;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * An NCube is a 1..n dimension structure which relates a set of individual values to each other by defining them within a matrix. The NCube may be the result of aggregations, cross-tabulation, time-series, etc. The NCube is described by its dimensions which are represented by categorical variables (variables with a set number of values of specific definition that can be used to identify a specific cell as part of a matrix address). The resulting cells can contain one or more measures, also defined by variables. In addition to the standard name, label, and description of the NCube, it contains a reference to a universe, defines both the normal source of the data in the cells and unit of analysis, the purpose of creating the structured data, the dimensions and measures, as well as the ability to attached any other attribute (i.e., footnote, cell or region specific note) to a specified area of the NCube. Three attribute serve as informational check values; dimensionCount, cellCount, and isClean.
 * <p>
 * <p>Java class for NCubeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="NCubeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}NCubeName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}ImputationReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}SourceUnit" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}AnalysisUnit" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Purpose" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}Dimension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}CoordinateRegion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}MeasureDefinition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}Attribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dimensionCount" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="cellCount" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="isClean" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NCubeType", propOrder = {
        "nCubeName",
        "label",
        "description",
        "universeReference",
        "imputationReference",
        "sourceUnit",
        "analysisUnit",
        "purpose",
        "dimension",
        "coordinateRegion",
        "measureDefinition",
        "attribute"
})
public class NCubeType
        extends VersionableType {

    @XmlElement(name = "NCubeName")
    protected List<NameType> nCubeName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "UniverseReference", namespace = "ddi:reusable:3_2")
    protected List<ReferenceType> universeReference;
    @XmlElement(name = "ImputationReference")
    protected ReferenceType imputationReference;
    @XmlElement(name = "SourceUnit")
    protected CodeValueType sourceUnit;
    @XmlElement(name = "AnalysisUnit", namespace = "ddi:reusable:3_2")
    protected CodeValueType analysisUnit;
    @XmlElement(name = "Purpose", namespace = "ddi:reusable:3_2")
    protected StructuredStringType purpose;
    @XmlElement(name = "Dimension")
    protected List<DimensionType> dimension;
    @XmlElement(name = "CoordinateRegion")
    protected List<CoordinateRegionType> coordinateRegion;
    @XmlElement(name = "MeasureDefinition")
    protected List<MeasureDefinitionType> measureDefinition;
    @XmlElement(name = "Attribute")
    protected List<AttributeType> attribute;
    @XmlAttribute(name = "dimensionCount")
    protected BigInteger dimensionCount;
    @XmlAttribute(name = "cellCount")
    protected BigInteger cellCount;
    @XmlAttribute(name = "isClean")
    protected Boolean isClean;

    /**
     * A name for the NCube. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the nCubeName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nCubeName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNCubeName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getNCubeName() {
        if (nCubeName == null) {
            nCubeName = new ArrayList<NameType>();
        }
        return this.nCubeName;
    }

    /**
     * A display label for the NCube. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and structure of the NCube. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to an imputation process described as a GeneralInstruction or GenerationInstruction held in a ProcessingInstructionScheme.Gets the value of the universeReference property.
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
     * The normal source of the information contained in the NCube. In the case of a survey this may be a respondent, proxy, interviewer, or other source. In the case of administrative data the position of a field on a form e.g., "top of page", "item 3", "generated by data processor", etc.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getImputationReference() {
        return imputationReference;
    }

    /**
     * Sets the value of the imputationReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setImputationReference(ReferenceType value) {
        this.imputationReference = value;
    }

    /**
     * The normal source of the information contained in the NCube. In the case of a survey this may be a respondent, proxy, interviewer, or other source. In the case of administrative data the position of a field on a form e.g., "top of page", "item 3", "generated by data processor", etc. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getSourceUnit() {
        return sourceUnit;
    }

    /**
     * Sets the value of the sourceUnit property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setSourceUnit(CodeValueType value) {
        this.sourceUnit = value;
    }

    /**
     * The entity to which the data refer, for example, individuals, families or households, groups, institutions/organizations, administrative units, etc. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getAnalysisUnit() {
        return analysisUnit;
    }

    /**
     * Sets the value of the analysisUnit property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setAnalysisUnit(CodeValueType value) {
        this.analysisUnit = value;
    }

    /**
     * Purpose for which the NCube was created. For example, designed to support a set of age pyramids generated yearly.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setPurpose(StructuredStringType value) {
        this.purpose = value;
    }

    /**
     * NCubes are defined by their dimensions. A dimension is provided a rank and a reference to a variable that describes it. Cell locations are "addressed" by the value of their intersect on each dimension provided in rank order.Gets the value of the dimension property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimension property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimension().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     */
    public List<DimensionType> getDimension() {
        if (dimension == null) {
            dimension = new ArrayList<DimensionType>();
        }
        return this.dimension;
    }

    /**
     * Defines the area of attachment for an attribute. It may be defined as the NCube as a whole or as certain dimensions or values of dimensions.Gets the value of the coordinateRegion property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coordinateRegion property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoordinateRegion().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoordinateRegionType }
     */
    public List<CoordinateRegionType> getCoordinateRegion() {
        if (coordinateRegion == null) {
            coordinateRegion = new ArrayList<CoordinateRegionType>();
        }
        return this.coordinateRegion;
    }

    /**
     * Defines the structure and type of measure captured within the cells. This may be repeated to describe multiple measure for the cells (i.e., count, percent of universe, dimensional percent, index, text, suppression flag, etc.).Gets the value of the measureDefinition property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measureDefinition property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasureDefinition().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureDefinitionType }
     */
    public List<MeasureDefinitionType> getMeasureDefinition() {
        if (measureDefinition == null) {
            measureDefinition = new ArrayList<MeasureDefinitionType>();
        }
        return this.measureDefinition;
    }

    /**
     * An attribute may be any object which should be attached to all or part of the NCube. It may be defined as a Variable or contain textual content (such as a footnote).Gets the value of the attribute property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeType }
     */
    public List<AttributeType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<AttributeType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the dimensionCount property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getDimensionCount() {
        return dimensionCount;
    }

    /**
     * Sets the value of the dimensionCount property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setDimensionCount(BigInteger value) {
        this.dimensionCount = value;
    }

    /**
     * Gets the value of the cellCount property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getCellCount() {
        return cellCount;
    }

    /**
     * Sets the value of the cellCount property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setCellCount(BigInteger value) {
        this.cellCount = value;
    }

    /**
     * Gets the value of the isClean property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsClean() {
        if (isClean == null) {
            return true;
        } else {
            return isClean;
        }
    }

    /**
     * Sets the value of the isClean property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsClean(Boolean value) {
        this.isClean = value;
    }

}
