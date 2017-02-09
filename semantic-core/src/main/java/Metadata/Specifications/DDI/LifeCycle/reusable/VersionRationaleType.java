//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Textual description of the rationale/purpose for the version change and a coded value to provide an internal processing flag within and organization or system. Note that versioning can only take place on objects owned by the specified DDI Agency. If you are creating a local instance of an object from another agency for current or future modification use BasedOnObject. If the changes being made result in what you determine to be new object rather than a version of a previous object, i.e. the change is too extensive to consider it a version of the existing object, create a new object and use BasedOnObject to provide a link to the object or objects that were a basis for the new object.
 * <p>
 * <p>Java class for VersionRationaleType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="VersionRationaleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}RationaleDescription" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}RationaleCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionRationaleType", propOrder = {
        "rationaleDescription",
        "rationaleCode"
})
public class VersionRationaleType {

    @XmlElement(name = "RationaleDescription")
    protected InternationalStringType rationaleDescription;
    @XmlElement(name = "RationaleCode")
    protected CodeValueType rationaleCode;

    /**
     * Textual description of the rationale/purpose for the version change to inform users as to the extent and implication of the version change. May be expressed in multiple languages.
     *
     * @return possible object is
     * {@link InternationalStringType }
     */
    public InternationalStringType getRationaleDescription() {
        return rationaleDescription;
    }

    /**
     * Sets the value of the rationaleDescription property.
     *
     * @param value allowed object is
     *              {@link InternationalStringType }
     */
    public void setRationaleDescription(InternationalStringType value) {
        this.rationaleDescription = value;
    }

    /**
     * RationaleCode is primarily for internal processing flags within an organization or system. Supports the use of an external controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getRationaleCode() {
        return rationaleCode;
    }

    /**
     * Sets the value of the rationaleCode property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setRationaleCode(CodeValueType value) {
        this.rationaleCode = value;
    }

}
