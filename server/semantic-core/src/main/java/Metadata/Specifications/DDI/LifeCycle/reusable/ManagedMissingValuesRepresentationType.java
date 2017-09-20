//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Means of describing the Missing Values within a managed representation so that they can be reused by multiple variables and questions. Variable has a separate Missing Values location for this representation. Questions must use a StructuredMixedResponseDomain to include both standard response and Missing ValueRange responses in a single question. In addition to the name, label, and description of the representation, the structure defines the type of the missing values, a optional generation instruction for deriving the value to be recorded, and the ability to define a blank as a missing value.
 * <p>
 * <p>Java class for ManagedMissingValuesRepresentationType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ManagedMissingValuesRepresentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ManagedMissingValuesRepresentationName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}MissingCodeRepresentation"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}MissingNumericRepresentation"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}MissingTextRepresentation"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ProcessingInstructionReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isBlankMissingValue" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedMissingValuesRepresentationType", propOrder = {
        "managedMissingValuesRepresentationName",
        "label",
        "description",
        "missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation",
        "processingInstructionReference"
})
public class ManagedMissingValuesRepresentationType
        extends VersionableType {

    @XmlElement(name = "ManagedMissingValuesRepresentationName")
    protected List<NameType> managedMissingValuesRepresentationName;
    @XmlElement(name = "Label")
    protected List<LabelType> label;
    @XmlElement(name = "Description")
    protected StructuredStringType description;
    @XmlElements({
            @XmlElement(name = "MissingCodeRepresentation", type = CodeRepresentationBaseType.class),
            @XmlElement(name = "MissingNumericRepresentation", type = NumericRepresentationBaseType.class),
            @XmlElement(name = "MissingTextRepresentation", type = TextRepresentationBaseType.class)
    })
    protected List<RepresentationType> missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation;
    @XmlElement(name = "ProcessingInstructionReference")
    protected ProcessingInstructionReferenceType processingInstructionReference;
    @XmlAttribute(name = "isBlankMissingValue")
    protected Boolean isBlankMissingValue;

    /**
     * A name for the missing value. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the managedMissingValuesRepresentationName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the managedMissingValuesRepresentationName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManagedMissingValuesRepresentationName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getManagedMissingValuesRepresentationName() {
        if (managedMissingValuesRepresentationName == null) {
            managedMissingValuesRepresentationName = new ArrayList<NameType>();
        }
        return this.managedMissingValuesRepresentationName;
    }

    /**
     * A display label for the managed representation. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the managed representation. May be expressed in multiple languages and supports the use of structured content.
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
     * Gets the value of the missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMissingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeRepresentationBaseType }
     * {@link NumericRepresentationBaseType }
     * {@link TextRepresentationBaseType }
     */
    public List<RepresentationType> getMissingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation() {
        if (missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation == null) {
            missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation = new ArrayList<RepresentationType>();
        }
        return this.missingCodeRepresentationOrMissingNumericRepresentationOrMissingTextRepresentation;
    }

    /**
     * An optional reference to a GenerationInstruction describing how to generate the value for this representation when used as a response domain or missing value representation.
     *
     * @return possible object is
     * {@link ProcessingInstructionReferenceType }
     */
    public ProcessingInstructionReferenceType getProcessingInstructionReference() {
        return processingInstructionReference;
    }

    /**
     * Sets the value of the processingInstructionReference property.
     *
     * @param value allowed object is
     *              {@link ProcessingInstructionReferenceType }
     */
    public void setProcessingInstructionReference(ProcessingInstructionReferenceType value) {
        this.processingInstructionReference = value;
    }

    /**
     * Gets the value of the isBlankMissingValue property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isIsBlankMissingValue() {
        if (isBlankMissingValue == null) {
            return true;
        } else {
            return isBlankMissingValue;
        }
    }

    /**
     * Sets the value of the isBlankMissingValue property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsBlankMissingValue(Boolean value) {
        this.isBlankMissingValue = value;
    }

}