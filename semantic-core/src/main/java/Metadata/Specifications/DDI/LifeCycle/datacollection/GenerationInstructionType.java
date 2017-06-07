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
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CommandCodeType;
import Metadata.Specifications.DDI.LifeCycle.reusable.OtherMaterialType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * Processing instructions for recodes, derivations from multiple question or variable sources, and derivations based on external sources. Instructions should be listed separately so they can be referenced individually.
 * <p>
 * <p>Java class for GenerationInstructionType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="GenerationInstructionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}SourceQuestion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}SourceVariable" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}ExternalInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}CommandCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}ControlConstructReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}Aggregation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isDerived" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenerationInstructionType", propOrder = {
        "sourceQuestion",
        "sourceVariable",
        "externalInformation",
        "description",
        "commandCode",
        "controlConstructReference",
        "aggregation"
})
public class GenerationInstructionType
        extends VersionableType {

    @XmlElement(name = "SourceQuestion")
    protected List<SourceReferenceType> sourceQuestion;
    @XmlElement(name = "SourceVariable")
    protected List<SourceReferenceType> sourceVariable;
    @XmlElement(name = "ExternalInformation")
    protected List<OtherMaterialType> externalInformation;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "CommandCode", namespace = "ddi:reusable:3_2")
    protected List<CommandCodeType> commandCode;
    @XmlElement(name = "ControlConstructReference")
    protected List<ControlConstructReferenceType> controlConstructReference;
    @XmlElement(name = "Aggregation")
    protected AggregationType aggregation;
    @XmlAttribute(name = "isDerived")
    protected Boolean isDerived;

    /**
     * Reference to a question used in the instruction.Gets the value of the sourceQuestion property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceQuestion property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceQuestion().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceReferenceType }
     */
    public List<SourceReferenceType> getSourceQuestion() {
        if (sourceQuestion == null) {
            sourceQuestion = new ArrayList<SourceReferenceType>();
        }
        return this.sourceQuestion;
    }

    /**
     * Reference to a variable used in the coding process Gets the value of the sourceVariable property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceVariable property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceVariable().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceReferenceType }
     */
    public List<SourceReferenceType> getSourceVariable() {
        if (sourceVariable == null) {
            sourceVariable = new ArrayList<SourceReferenceType>();
        }
        return this.sourceVariable;
    }

    /**
     * Reference to an external source of information used in the coding process, for example a value from a chart, etc.Gets the value of the externalInformation property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalInformation property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalInformation().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherMaterialType }
     */
    public List<OtherMaterialType> getExternalInformation() {
        if (externalInformation == null) {
            externalInformation = new ArrayList<OtherMaterialType>();
        }
        return this.externalInformation;
    }

    /**
     * A description of the generation instruction. May be expressed in multiple languages and supports the use of structured content.
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
     * Structured information used by a system to process the instruction.Gets the value of the commandCode property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commandCode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommandCode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandCodeType }
     */
    public List<CommandCodeType> getCommandCode() {
        if (commandCode == null) {
            commandCode = new ArrayList<CommandCodeType>();
        }
        return this.commandCode;
    }

    /**
     * A control construct which is used to describe or process the instruction.Gets the value of the controlConstructReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlConstructReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlConstructReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlConstructReferenceType }
     */
    public List<ControlConstructReferenceType> getControlConstructReference() {
        if (controlConstructReference == null) {
            controlConstructReference = new ArrayList<ControlConstructReferenceType>();
        }
        return this.controlConstructReference;
    }

    /**
     * Describes the aggregation process, identifying both the independent and dependent variables within the process.
     *
     * @return possible object is
     * {@link AggregationType }
     */
    public AggregationType getAggregation() {
        return aggregation;
    }

    /**
     * Sets the value of the aggregation property.
     *
     * @param value allowed object is
     *              {@link AggregationType }
     */
    public void setAggregation(AggregationType value) {
        this.aggregation = value;
    }

    /**
     * Gets the value of the isDerived property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsDerived() {
        if (isDerived == null) {
            return true;
        } else {
            return isDerived;
        }
    }

    /**
     * Sets the value of the isDerived property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsDerived(Boolean value) {
        this.isDerived = value;
    }

}