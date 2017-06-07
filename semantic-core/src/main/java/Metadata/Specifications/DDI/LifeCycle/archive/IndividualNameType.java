//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.archive;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.DateType;
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalStringType;


/**
 * The name of an individual broken out into its component parts of prefix, first/given name, middle name, last/family/surname, and suffix. The preferred compilation of the name parts may also be provided. The legal or formal name of the individual should have the isFormal attribute set to true. The preferred name should be noted with the isPreferred attribute. The attribute sex provides information to assist in the appropriate use of pronouns.
 * <p>
 * <p>Java class for IndividualNameType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="IndividualNameType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="SIPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FirstGiven" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Middle" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LastFamily" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FullName" type="{ddi:reusable:3_2}InternationalStringType" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}EffectivePeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Abbreviation" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}TypeOfIndividualName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sex" type="{ddi:archive:3_2}SexSpecificationType" /&gt;
 *       &lt;attribute name="isPreferred" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="context" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="isFormal" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualNameType", propOrder = {
        "prefix",
        "firstGiven",
        "middle",
        "lastFamily",
        "suffix",
        "fullName",
        "effectivePeriod",
        "abbreviation",
        "typeOfIndividualName"
})
public class IndividualNameType {

    @XmlElement(name = "SIPrefix")
    protected String prefix;
    @XmlElement(name = "FirstGiven")
    protected String firstGiven;
    @XmlElement(name = "Middle")
    protected List<String> middle;
    @XmlElement(name = "LastFamily")
    protected String lastFamily;
    @XmlElement(name = "Suffix")
    protected String suffix;
    @XmlElement(name = "FullName")
    protected InternationalStringType fullName;
    @XmlElement(name = "EffectivePeriod", namespace = "ddi:reusable:3_2")
    protected DateType effectivePeriod;
    @XmlElement(name = "Abbreviation", namespace = "ddi:reusable:3_2")
    protected InternationalStringType abbreviation;
    @XmlElement(name = "TypeOfIndividualName")
    protected CodeValueType typeOfIndividualName;
    @XmlAttribute(name = "sex")
    protected SexSpecificationType sex;
    @XmlAttribute(name = "isPreferred")
    protected Boolean isPreferred;
    @XmlAttribute(name = "context")
    protected String context;
    @XmlAttribute(name = "isFormal")
    protected Boolean isFormal;

    /**
     * Gets the value of the prefix property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the firstGiven property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstGiven() {
        return firstGiven;
    }

    /**
     * Sets the value of the firstGiven property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstGiven(String value) {
        this.firstGiven = value;
    }

    /**
     * Gets the value of the middle property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middle property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddle().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getMiddle() {
        if (middle == null) {
            middle = new ArrayList<String>();
        }
        return this.middle;
    }

    /**
     * Gets the value of the lastFamily property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLastFamily() {
        return lastFamily;
    }

    /**
     * Sets the value of the lastFamily property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLastFamily(String value) {
        this.lastFamily = value;
    }

    /**
     * Gets the value of the suffix property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the fullName property.
     *
     * @return possible object is
     * {@link InternationalStringType }
     */
    public InternationalStringType getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     *
     * @param value allowed object is
     *              {@link InternationalStringType }
     */
    public void setFullName(InternationalStringType value) {
        this.fullName = value;
    }

    /**
     * Clarifies when the name information is accurate.
     *
     * @return possible object is
     * {@link DateType }
     */
    public DateType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Sets the value of the effectivePeriod property.
     *
     * @param value allowed object is
     *              {@link DateType }
     */
    public void setEffectivePeriod(DateType value) {
        this.effectivePeriod = value;
    }

    /**
     * An abbreviation or acronym for the name. This may be expressed in multiple languages. It is assumed that if only a single language is provided that it may be used in any of the other languages within which the name itself is expressed.
     *
     * @return possible object is
     * {@link InternationalStringType }
     */
    public InternationalStringType getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the value of the abbreviation property.
     *
     * @param value allowed object is
     *              {@link InternationalStringType }
     */
    public void setAbbreviation(InternationalStringType value) {
        this.abbreviation = value;
    }

    /**
     * The type of individual name provided. the use of a controlled vocabulary is strongly recommended. At minimum his should include, e.g. PreviousFormalName, Nickname (or CommonName), Other.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfIndividualName() {
        return typeOfIndividualName;
    }

    /**
     * Sets the value of the typeOfIndividualName property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfIndividualName(CodeValueType value) {
        this.typeOfIndividualName = value;
    }

    /**
     * Gets the value of the sex property.
     *
     * @return possible object is
     * {@link SexSpecificationType }
     */
    public SexSpecificationType getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     *
     * @param value allowed object is
     *              {@link SexSpecificationType }
     */
    public void setSex(SexSpecificationType value) {
        this.sex = value;
    }

    /**
     * Gets the value of the isPreferred property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsPreferred() {
        return isPreferred;
    }

    /**
     * Sets the value of the isPreferred property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsPreferred(Boolean value) {
        this.isPreferred = value;
    }

    /**
     * Gets the value of the context property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the isFormal property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsFormal() {
        return isFormal;
    }

    /**
     * Sets the value of the isFormal property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsFormal(Boolean value) {
        this.isFormal = value;
    }

}