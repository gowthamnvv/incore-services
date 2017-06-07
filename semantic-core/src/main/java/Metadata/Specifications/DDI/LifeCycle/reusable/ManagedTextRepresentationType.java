//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Means of describing text based content used by reference to define Variable Representation and Question Response Domain. Text Representations cover all non-code and non-category representations/response domains that should be treated or analyzed as characters regardless of whether the character is a number or a letter. In addition to the name, label, and description, the scheme defines the maximum and minimum length of the allowed text and allows for the use of a regular expression to further define the valid content.
 * <p>
 * <p>Java class for ManagedTextRepresentationType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ManagedTextRepresentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ManagedTextRepresentationName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}RecommendedDataType" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}GenericOutputFormat" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="minLength" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="regExp" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="classificationLevel" type="{ddi:reusable:3_2}CategoryRelationCodeType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedTextRepresentationType", propOrder = {
        "managedTextRepresentationName",
        "label",
        "description",
        "recommendedDataType",
        "genericOutputFormat"
})
public class ManagedTextRepresentationType
        extends VersionableType {

    @XmlElement(name = "ManagedTextRepresentationName")
    protected List<NameType> managedTextRepresentationName;
    @XmlElement(name = "Label")
    protected List<LabelType> label;
    @XmlElement(name = "Description")
    protected StructuredStringType description;
    @XmlElement(name = "RecommendedDataType")
    protected CodeValueType recommendedDataType;
    @XmlElement(name = "GenericOutputFormat")
    protected CodeValueType genericOutputFormat;
    @XmlAttribute(name = "maxLength")
    protected BigInteger maxLength;
    @XmlAttribute(name = "minLength")
    protected BigInteger minLength;
    @XmlAttribute(name = "regExp")
    protected String regExp;
    @XmlAttribute(name = "classificationLevel")
    protected CategoryRelationCodeType classificationLevel;

    /**
     * A name for the ManagedTextRepresentation. May be expressed in multiple languages. Repeat the element to express names with different content, for example, different names for different systems.Gets the value of the managedTextRepresentationName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the managedTextRepresentationName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManagedTextRepresentationName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getManagedTextRepresentationName() {
        if (managedTextRepresentationName == null) {
            managedTextRepresentationName = new ArrayList<NameType>();
        }
        return this.managedTextRepresentationName;
    }

    /**
     * A display label for the representation. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the representation. May be expressed in multiple languages and supports the use of structured content.
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
     * This field provides the recommended treatment of the data within an application. The value should come from a controlled vocabulary - recommended values include the set found in W3C XML Schema Part 2, but excluding string sub-types, QNAME, and NOTATION.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getRecommendedDataType() {
        return recommendedDataType;
    }

    /**
     * Sets the value of the recommendedDataType property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setRecommendedDataType(CodeValueType value) {
        this.recommendedDataType = value;
    }

    /**
     * This field provides a recommended generic treatment of the data for display by an application. The value should come from a controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getGenericOutputFormat() {
        return genericOutputFormat;
    }

    /**
     * Sets the value of the genericOutputFormat property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setGenericOutputFormat(CodeValueType value) {
        this.genericOutputFormat = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the minLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the regExp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegExp() {
        return regExp;
    }

    /**
     * Sets the value of the regExp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegExp(String value) {
        this.regExp = value;
    }

    /**
     * Gets the value of the classificationLevel property.
     *
     * @return possible object is
     * {@link CategoryRelationCodeType }
     */
    public CategoryRelationCodeType getClassificationLevel() {
        return classificationLevel;
    }

    /**
     * Sets the value of the classificationLevel property.
     *
     * @param value allowed object is
     *              {@link CategoryRelationCodeType }
     */
    public void setClassificationLevel(CategoryRelationCodeType value) {
        this.classificationLevel = value;
    }

}