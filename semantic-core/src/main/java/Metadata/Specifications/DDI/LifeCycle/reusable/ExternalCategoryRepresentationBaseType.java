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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Structures a response domain based on categorization that is described in an external non-DDI structure. Includes a UsageDescription that should provide information on how the external source is to be used.
 * <p>
 * <p>Java class for ExternalCategoryRepresentationBaseType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ExternalCategoryRepresentationBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}RepresentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExternalCategoryReference" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}UsageDescription" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCategoryRepresentationBaseType", propOrder = {
        "externalCategoryReference",
        "usageDescription"
})
public class ExternalCategoryRepresentationBaseType
        extends RepresentationType {

    @XmlElement(name = "ExternalCategoryReference", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String externalCategoryReference;
    @XmlElement(name = "UsageDescription")
    protected StructuredStringType usageDescription;

    /**
     * Gets the value of the externalCategoryReference property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExternalCategoryReference() {
        return externalCategoryReference;
    }

    /**
     * Sets the value of the externalCategoryReference property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExternalCategoryReference(String value) {
        this.externalCategoryReference = value;
    }

    /**
     * A description of the use of the external category file.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getUsageDescription() {
        return usageDescription;
    }

    /**
     * Sets the value of the usageDescription property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setUsageDescription(StructuredStringType value) {
        this.usageDescription = value;
    }

}
