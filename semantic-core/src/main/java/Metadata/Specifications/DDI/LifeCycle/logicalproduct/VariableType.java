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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ParameterType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * Describes the structure of a Variable. This is the applied expression of a data item within a data set and maps to the GSIM ImplementedVariable. In addition to the standard name, label, and description, includes a reference to a source parameter, represented variable, conceptual variable, universe, concept, question, source variable, and embargo information. It identifies the normal source of the data in the variable, the unit of analysis, whether the variable provides temporal or geographic information, or serves as a weight for other variables in the data, and provides a full description of its representation.
 * <p>
 * <p>Java class for VariableType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="VariableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}VariableName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}OutParameter" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}SourceParameterReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}SourceVariableReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}RepresentedVariableReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptualVariableReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniverseReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}QuestionReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}EmbargoReference" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}SourceUnit" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}AnalysisUnit" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}VariableRepresentation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isTemporal" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="isGeographic" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="isWeight" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableType", propOrder = {
        "variableName",
        "label",
        "description",
        "outParameter",
        "sourceParameterReference",
        "sourceVariableReference",
        "representedVariableReference",
        "conceptualVariableReference",
        "universeReference",
        "conceptReference",
        "questionReference",
        "embargoReference",
        "sourceUnit",
        "analysisUnit",
        "variableRepresentation"
})
public class VariableType
        extends VersionableType {

    @XmlElement(name = "VariableName")
    protected List<NameType> variableName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "OutParameter", namespace = "ddi:reusable:3_2")
    protected ParameterType outParameter;
    @XmlElement(name = "SourceParameterReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType sourceParameterReference;
    @XmlElement(name = "SourceVariableReference", namespace = "ddi:reusable:3_2")
    protected List<ReferenceType> sourceVariableReference;
    @XmlElement(name = "RepresentedVariableReference")
    protected ReferenceType representedVariableReference;
    @XmlElement(name = "ConceptualVariableReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType conceptualVariableReference;
    @XmlElement(name = "UniverseReference", namespace = "ddi:reusable:3_2")
    protected List<ReferenceType> universeReference;
    @XmlElement(name = "ConceptReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType conceptReference;
    @XmlElement(name = "QuestionReference", namespace = "ddi:reusable:3_2")
    protected List<ReferenceType> questionReference;
    @XmlElement(name = "EmbargoReference")
    protected ReferenceType embargoReference;
    @XmlElement(name = "SourceUnit")
    protected CodeValueType sourceUnit;
    @XmlElement(name = "AnalysisUnit", namespace = "ddi:reusable:3_2")
    protected CodeValueType analysisUnit;
    @XmlElement(name = "VariableRepresentation")
    protected VariableRepresentationType variableRepresentation;
    @XmlAttribute(name = "isTemporal")
    protected Boolean isTemporal;
    @XmlAttribute(name = "isGeographic")
    protected Boolean isGeographic;
    @XmlAttribute(name = "isWeight")
    protected Boolean isWeight;

    /**
     * A name for the Variable. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the variableName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getVariableName() {
        if (variableName == null) {
            variableName = new ArrayList<NameType>();
        }
        return this.variableName;
    }

    /**
     * A display label for the Variable. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the Variable. May be expressed in multiple languages and supports the use of structured content.
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
     * Assigns a parameter that contains output from the Variable so that it can be bound to an InParameter of an instruction or act as the SourceParameter of another Variable.
     *
     * @return possible object is
     * {@link ParameterType }
     */
    public ParameterType getOutParameter() {
        return outParameter;
    }

    /**
     * Sets the value of the outParameter property.
     *
     * @param value allowed object is
     *              {@link ParameterType }
     */
    public void setOutParameter(ParameterType value) {
        this.outParameter = value;
    }

    /**
     * Reference to an OutParameter that serves as the source for the content of this variable.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getSourceParameterReference() {
        return sourceParameterReference;
    }

    /**
     * Sets the value of the sourceParameterReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setSourceParameterReference(ReferenceType value) {
        this.sourceParameterReference = value;
    }

    /**
     * Reference to variable(s) used as a basis for recoding, derivation, or other means of calculating the data for this variable. This reference is intended to provide basic information on the source variable structure including value representation, measurement unit, etc. Note that if a variable is used by reference within multiple VariableSchemes you can identify its role within a specific VariableScheme by including that VariableScheme in the sourceContext attribute of the reference. Use ProcessingInstructionReference to provide additional information on the transformation of the source variable(s) into the data for this variable. If additional processing detail is required use the InParameter, OutParameter, and ParameterLinkage options in the GenerationInstruction and ProcessingInstructionReference.Gets the value of the sourceVariableReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceVariableReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceVariableReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getSourceVariableReference() {
        if (sourceVariableReference == null) {
            sourceVariableReference = new ArrayList<ReferenceType>();
        }
        return this.sourceVariableReference;
    }

    /**
     * Reference to the RepresentedVariable that describes the core of this variable (the RepresentedVariable that the variable is the implementation of). The RepresentedVariable contains the broad reusable specification of the Variable, i.e., concept, universe, and value representation. These may be constrained by specifications within the Variable description. TypeOfObject should be set to RepresentedVariable.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getRepresentedVariableReference() {
        return representedVariableReference;
    }

    /**
     * Sets the value of the representedVariableReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setRepresentedVariableReference(ReferenceType value) {
        this.representedVariableReference = value;
    }

    /**
     * Reference to the ConceptualVariable that describes the core of this variable. The ConceptualVariable provides linked Concept and Universe specifications. These may be constrained by specifications within the Variable description. TypeOfObject should be set to ConceptualVariable.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getConceptualVariableReference() {
        return conceptualVariableReference;
    }

    /**
     * Sets the value of the conceptualVariableReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setConceptualVariableReference(ReferenceType value) {
        this.conceptualVariableReference = value;
    }

    /**
     * Reference to the universe statement containing a description of the persons or other elements that this variable refers to, and to which any analytic results refer. If more than one universe is referenced the universe of the variable is the intersect of the referenced universes.Gets the value of the universeReference property.
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
     * Reference to the concept measured by this variable.
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
     * Reference to question(s) used to collect data for this variable. This references the wording and response domain of the question, not the question flow (if the same question was asked in reference to multiple objects (i.e., Age of each child). Use SourceParameterReference and/or VariableRepresentation/ProcessingInstructionReference to differentiate sources associated with flow patterns or data processing instructions.Gets the value of the questionReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the questionReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getQuestionReference() {
        if (questionReference == null) {
            questionReference = new ArrayList<ReferenceType>();
        }
        return this.questionReference;
    }

    /**
     * Reference to any embargoes placed on the contents of this variable. Embargoes may limit access to the data and/or metadata to specific groups and/or for specified periods of time.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getEmbargoReference() {
        return embargoReference;
    }

    /**
     * Sets the value of the embargoReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setEmbargoReference(ReferenceType value) {
        this.embargoReference = value;
    }

    /**
     * The normal source of the information contained in the variable. In the case of a survey this may be a respondent, proxy, interviewer, or other source. In the case of administrative data the position of a field on a form e.g., "top of page", "item 3", "generated by data processor", etc. Supports the use of an external controlled vocabulary.
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
     * Describes the representation of the variable in the data set, including allowed content, data typing, and computation information.
     *
     * @return possible object is
     * {@link VariableRepresentationType }
     */
    public VariableRepresentationType getVariableRepresentation() {
        return variableRepresentation;
    }

    /**
     * Sets the value of the variableRepresentation property.
     *
     * @param value allowed object is
     *              {@link VariableRepresentationType }
     */
    public void setVariableRepresentation(VariableRepresentationType value) {
        this.variableRepresentation = value;
    }

    /**
     * Gets the value of the isTemporal property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsTemporal() {
        if (isTemporal == null) {
            return false;
        } else {
            return isTemporal;
        }
    }

    /**
     * Sets the value of the isTemporal property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsTemporal(Boolean value) {
        this.isTemporal = value;
    }

    /**
     * Gets the value of the isGeographic property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsGeographic() {
        if (isGeographic == null) {
            return false;
        } else {
            return isGeographic;
        }
    }

    /**
     * Sets the value of the isGeographic property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsGeographic(Boolean value) {
        this.isGeographic = value;
    }

    /**
     * Gets the value of the isWeight property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsWeight() {
        if (isWeight == null) {
            return false;
        } else {
            return isWeight;
        }
    }

    /**
     * Sets the value of the isWeight property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsWeight(Boolean value) {
        this.isWeight = value;
    }

}
