//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.datacollection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ContentDateOffsetType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NumericRepresentationBaseType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ParameterType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ResponseCardinalityType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * A response domain capturing a numeric response (the intent is to analyze the response as a number) for a question. Contains the equivalent content of a NumericRepresentation including the numeric range, numeric type code, format, scale, decimal position, and interval. Adds a set of elements available to all Response Domains; Label, Description, OutParameter, designation of response cardinality, and a declaration of an offset date for the data content. Has an equivalent NumericDomainReference which references a ManagedNumericRepresentation.
 * <p>
 * <p>Java class for NumericDomainType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="NumericDomainType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}NumericRepresentationBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}OutParameter" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ResponseCardinality" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ContentDateOffset" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericDomainType", propOrder = {
        "label",
        "description",
        "outParameter",
        "responseCardinality",
        "contentDateOffset"
})
public class NumericDomainType
        extends NumericRepresentationBaseType {

    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "OutParameter", namespace = "ddi:reusable:3_2")
    protected ParameterType outParameter;
    @XmlElement(name = "ResponseCardinality", namespace = "ddi:reusable:3_2")
    protected ResponseCardinalityType responseCardinality;
    @XmlElement(name = "ContentDateOffset", namespace = "ddi:reusable:3_2")
    protected ContentDateOffsetType contentDateOffset;

    /**
     * A display label for the domain. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the content and purpose of the domain. May be expressed in multiple languages and supports the use of structured content.
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
     * Allows for the response to be bound to one of the QuestionItem's OutParameters, so the collected information can be used elsewhere, for example as inputs to subsequent questions in an Instrument or to a GenerationInstruction. If multiple responses are possible, this would represent and ordered array of the responses.
     *
     * @return possible object is
     * {@link ParameterType }
     */
    public ParameterType getOutParameter() {
        return outParameter;
    }

    /**
     * Sets the value of the outParameter property.
     *
     * @param value allowed object is
     *              {@link ParameterType }
     */
    public void setOutParameter(ParameterType value) {
        this.outParameter = value;
    }

    /**
     * Allows the designation of the minimum and maximum number of responses allowed for this response domain.
     *
     * @return possible object is
     * {@link ResponseCardinalityType }
     */
    public ResponseCardinalityType getResponseCardinality() {
        return responseCardinality;
    }

    /**
     * Sets the value of the responseCardinality property.
     *
     * @param value allowed object is
     *              {@link ResponseCardinalityType }
     */
    public void setResponseCardinality(ResponseCardinalityType value) {
        this.responseCardinality = value;
    }

    /**
     * Identifies the difference between the date applied to the data as a whole and this specific item such as previous year's income or residence 5 years ago.
     *
     * @return possible object is
     * {@link ContentDateOffsetType }
     */
    public ContentDateOffsetType getContentDateOffset() {
        return contentDateOffset;
    }

    /**
     * Sets the value of the contentDateOffset property.
     *
     * @param value allowed object is
     *              {@link ContentDateOffsetType }
     */
    public void setContentDateOffset(ContentDateOffsetType value) {
        this.contentDateOffset = value;
    }

}
