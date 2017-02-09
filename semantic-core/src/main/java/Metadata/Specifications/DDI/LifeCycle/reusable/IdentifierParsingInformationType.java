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
import javax.xml.bind.annotation.XmlType;


/**
 * Provides structural information for parsing the identification code structure of the Authorized Source into its separate parts.
 * <p>
 * <p>Java class for IdentifierParsingInformationType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="IdentifierParsingInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ParentIdentificationPortion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UniqueIdentificationPortion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="arrayBase" type="{ddi:reusable:3_2}ArrayBaseCodeType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifierParsingInformationType", propOrder = {
        "parentIdentificationPortion",
        "uniqueIdentificationPortion"
})
public class IdentifierParsingInformationType {

    @XmlElement(name = "ParentIdentificationPortion")
    protected List<IdentificationPortionType> parentIdentificationPortion;
    @XmlElement(name = "UniqueIdentificationPortion")
    protected IdentificationPortionType uniqueIdentificationPortion;
    @XmlAttribute(name = "arrayBase")
    protected String arrayBase;

    /**
     * Identifies the parent portions of the code string as individual segments. Repeat for each parental segment.Gets the value of the parentIdentificationPortion property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parentIdentificationPortion property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParentIdentificationPortion().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationPortionType }
     */
    public List<IdentificationPortionType> getParentIdentificationPortion() {
        if (parentIdentificationPortion == null) {
            parentIdentificationPortion = new ArrayList<IdentificationPortionType>();
        }
        return this.parentIdentificationPortion;
    }

    /**
     * Identifies the unique portion of the code string as a segment.
     *
     * @return possible object is
     * {@link IdentificationPortionType }
     */
    public IdentificationPortionType getUniqueIdentificationPortion() {
        return uniqueIdentificationPortion;
    }

    /**
     * Sets the value of the uniqueIdentificationPortion property.
     *
     * @param value allowed object is
     *              {@link IdentificationPortionType }
     */
    public void setUniqueIdentificationPortion(IdentificationPortionType value) {
        this.uniqueIdentificationPortion = value;
    }

    /**
     * Gets the value of the arrayBase property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArrayBase() {
        return arrayBase;
    }

    /**
     * Sets the value of the arrayBase property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArrayBase(String value) {
        this.arrayBase = value;
    }

}
