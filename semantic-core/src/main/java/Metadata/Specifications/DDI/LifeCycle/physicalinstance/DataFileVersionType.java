//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicalinstance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionRationaleType;


/**
 * Provides the version information for the data file related to this physical instance. Note that while Physical Instance allows for multiple copies of the same data file (such as backup copies) the assumption is that they are identical in terms of content, layout, format and version. The minimum information required is the versionNumber. Additional information on the versionDate, the type of version number when multiple types are supported by an agency, as well as information on VersionResponsibility (inline or by reference) and VersionRationale are available to provide additional information for process tracking and/or informing users of the differences between this and the previous version of the file.
 * <p>
 * <p>Java class for DataFileVersionType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DataFileVersionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeOfVersionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}VersionResponsibility"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}VersionResponsibilityReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{ddi:reusable:3_2}VersionRationale" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versionNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="versionDate" type="{ddi:reusable:3_2}BaseDateType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataFileVersionType", propOrder = {
        "typeOfVersionNumber",
        "versionResponsibility",
        "versionResponsibilityReference",
        "versionRationale"
})
public class DataFileVersionType {

    @XmlElement(name = "TypeOfVersionNumber")
    protected String typeOfVersionNumber;
    @XmlElement(name = "VersionResponsibility", namespace = "ddi:reusable:3_2")
    protected String versionResponsibility;
    @XmlElement(name = "VersionResponsibilityReference", namespace = "ddi:reusable:3_2")
    protected ReferenceType versionResponsibilityReference;
    @XmlElement(name = "VersionRationale", namespace = "ddi:reusable:3_2")
    protected VersionRationaleType versionRationale;
    @XmlAttribute(name = "versionNumber", required = true)
    protected String versionNumber;
    @XmlAttribute(name = "versionDate")
    protected String versionDate;

    /**
     * Gets the value of the typeOfVersionNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTypeOfVersionNumber() {
        return typeOfVersionNumber;
    }

    /**
     * Sets the value of the typeOfVersionNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTypeOfVersionNumber(String value) {
        this.typeOfVersionNumber = value;
    }

    /**
     * Person or organization within the MaintenanceAgency responsible for the version change. If it is important to retain the affiliation between and individual responsible for the version and his/her agency, it may be included in this notation. This is primarily intended for internal use.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersionResponsibility() {
        return versionResponsibility;
    }

    /**
     * Sets the value of the versionResponsibility property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersionResponsibility(String value) {
        this.versionResponsibility = value;
    }

    /**
     * Reference person or organization within the MaintenanceAgency responsible for the version change, as described in an OrganizationScheme. If it is important to retain the affiliation between and individual responsible for the version and his/her agency, a Relation should be created between the individual referenced here and his/her organization. This is primarily intended for internal use.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getVersionResponsibilityReference() {
        return versionResponsibilityReference;
    }

    /**
     * Sets the value of the versionResponsibilityReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setVersionResponsibilityReference(ReferenceType value) {
        this.versionResponsibilityReference = value;
    }

    /**
     * Textual description of the rationale/purpose for a version change.
     *
     * @return possible object is
     * {@link VersionRationaleType }
     */
    public VersionRationaleType getVersionRationale() {
        return versionRationale;
    }

    /**
     * Sets the value of the versionRationale property.
     *
     * @param value allowed object is
     *              {@link VersionRationaleType }
     */
    public void setVersionRationale(VersionRationaleType value) {
        this.versionRationale = value;
    }

    /**
     * Gets the value of the versionNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersionNumber(String value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the versionDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersionDate() {
        return versionDate;
    }

    /**
     * Sets the value of the versionDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersionDate(String value) {
        this.versionDate = value;
    }

}