//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.datacollection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.IdentifiableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * Describes the type of sample, sample design and provides details on drawing the sample. In addition to the descriptive narrative supports the use of a brief term or controlled vocabulary to classify the type of sampling procedure described.
 * <p>
 * <p>Java class for SamplingProcedureType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="SamplingProcedureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}IdentifiableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}TypeOfSamplingProcedure" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SamplingProcedureType", propOrder = {
        "typeOfSamplingProcedure",
        "description"
})
public class SamplingProcedureType
        extends IdentifiableType {

    @XmlElement(name = "TypeOfSamplingProcedure")
    protected CodeValueType typeOfSamplingProcedure;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;

    /**
     * Allows brief identification of sampling procedure used with the option of using a controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfSamplingProcedure() {
        return typeOfSamplingProcedure;
    }

    /**
     * Sets the value of the typeOfSamplingProcedure property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfSamplingProcedure(CodeValueType value) {
        this.typeOfSamplingProcedure = value;
    }

    /**
     * Full description of the sampling procedure. This may include information on the sample frame, sampling methodology, and procedures for identifying and selecting sub-populations. Supports structured content and multiple language content.
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

}
