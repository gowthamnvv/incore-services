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
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalCodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * Details of an individual including name, contact information, a definition, keywords to support searching, their regional affiliation, language ability and any additional information. The individual and specific pieces of information regarding the individual may be tagged for information privacy.
 * <p>
 * <p>Java class for IndividualType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="IndividualType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:archive:3_2}IndividualIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}RegionalCoverage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}AdditionalInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}LanguageAbility" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}ContactInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{ddi:archive:3_2}PRIVACY"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualType", propOrder = {
        "individualIdentification",
        "description",
        "keyword",
        "regionalCoverage",
        "additionalInformation",
        "languageAbility",
        "contactInformation"
})
public class IndividualType extends VersionableType {

    @XmlElement(name = "IndividualIdentification")
    protected IndividualIdentificationType individualIdentification;

    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;

    @XmlElement(name = "Keyword", namespace = "ddi:reusable:3_2")
    protected List<InternationalCodeValueType> keyword;

    @XmlElement(name = "RegionalCoverage")
    protected List<CodeValueType> regionalCoverage;

    @XmlElement(name = "AdditionalInformation")
    protected List<AdditionalInformationType> additionalInformation;

    @XmlElement(name = "LanguageAbility")
    protected List<IndividualLanguageType> languageAbility;

    @XmlElement(name = "ContactInformation")
    protected List<ContactInformationType> contactInformation;

    @XmlAttribute(name = "privacy")
    protected String privacy;

    /**
     * Identifying information about the individual.
     *
     * @return possible object is
     * {@link IndividualIdentificationType }
     */
    public IndividualIdentificationType getIndividualIdentification() {
        return individualIdentification;
    }

    /**
     * Sets the value of the individualIdentification property.
     *
     * @param value allowed object is
     *              {@link IndividualIdentificationType }
     */
    public void setIndividualIdentification(IndividualIdentificationType value) {
        this.individualIdentification = value;
    }

    /**
     * A description of the individual. Supports multiple languages and optional structured content.
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
     * Keywords used to classify an individual or their activities. May be used to support searching.Gets the value of the keyword property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
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
     * The regional coverage of the individual. The geographic regions within which the individual is active.Gets the value of the regionalCoverage property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionalCoverage property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionalCoverage().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeValueType }
     */
    public List<CodeValueType> getRegionalCoverage() {
        if (regionalCoverage == null) {
            regionalCoverage = new ArrayList<CodeValueType>();
        }
        return this.regionalCoverage;
    }

    /**
     * Any additional information you which to note about the individual. Supports multiple languages and optional structured content. A privacy tag may be used.Gets the value of the additionalInformation property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInformation property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInformation().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalInformationType }
     */
    public List<AdditionalInformationType> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new ArrayList<AdditionalInformationType>();
        }
        return this.additionalInformation;
    }

    /**
     * Use to specify the languages known by the individual in terms of their ability to  speak, read, and write the language. May be repeated to cover multiple languages.Gets the value of the languageAbility property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageAbility property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageAbility().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualLanguageType }
     */
    public List<IndividualLanguageType> getLanguageAbility() {
        if (languageAbility == null) {
            languageAbility = new ArrayList<IndividualLanguageType>();
        }
        return this.languageAbility;
    }

    /**
     * Contact information for the individual including location specification, address, URL, phone numbers, and other means of communication access. Address, location, telephone, and other means of communication can be repeated to express multiple means of a single type or change over time. Each major piece of contact information (with exception of URL contains the element EffectiveDates in order to date stamp the period for which the information is valid.Gets the value of the contactInformation property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactInformation property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactInformation().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInformationType }
     */
    public List<ContactInformationType> getContactInformation() {
        if (contactInformation == null) {
            contactInformation = new ArrayList<ContactInformationType>();
        }
        return this.contactInformation;
    }

    /**
     * Gets the value of the privacy property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets the value of the privacy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrivacy(String value) {
        this.privacy = value;
    }
}
