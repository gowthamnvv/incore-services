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
 * Describes any deviations from the planned sample design. These may be for reasons of practicality, implementation issues, or other reasons. In addition to a narrative description allows for use of a brief term or controlled vocabulary term to classify the type of deviation.
 * <p>
 * <p>Java class for DeviationFromSampleDesignType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DeviationFromSampleDesignType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}IdentifiableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}TypeOfDeviationFromSampleDesign" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviationFromSampleDesignType", propOrder = {
        "typeOfDeviationFromSampleDesign",
        "description"
})
public class DeviationFromSampleDesignType
        extends IdentifiableType {

    @XmlElement(name = "TypeOfDeviationFromSampleDesign")
    protected CodeValueType typeOfDeviationFromSampleDesign;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;

    /**
     * Allows brief identification of the deviation from the sample design with the option of using a controlled vocabulary.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getTypeOfDeviationFromSampleDesign() {
        return typeOfDeviationFromSampleDesign;
    }

    /**
     * Sets the value of the typeOfDeviationFromSampleDesign property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setTypeOfDeviationFromSampleDesign(CodeValueType value) {
        this.typeOfDeviationFromSampleDesign = value;
    }

    /**
     * Full description of deviation from the sample design. Supports structured content and multiple language content.
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