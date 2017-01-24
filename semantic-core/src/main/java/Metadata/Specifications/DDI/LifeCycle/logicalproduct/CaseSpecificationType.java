//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.logicalproduct;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;


/**
 * Case specification allows different unique identifiers to be used based on the value of an identified variable. In some cases the value of a variable (such as a geographic level) results in a different set of variables required to identify a unique case. Case specification is used to capture these combinations. For example: a file containing State, County, and Place records. The unique identifier for a State requires a combination of GeoLevel=State and the variable STATE. Place would require a combination of GeoLevel=Place and the variables STATE and PLACE.
 * <p>
 * <p>Java class for CaseSpecificationType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CaseSpecificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}ConditionalVariableReference"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}VariableReference" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseSpecificationType", propOrder = {
        "conditionalVariableReference",
        "variableReference"
})
public class CaseSpecificationType {

    @XmlElement(name = "ConditionalVariableReference", required = true)
    protected ConditionalVariableReferenceType conditionalVariableReference;
    @XmlElement(name = "VariableReference", namespace = "ddi:reusable:3_2", required = true)
    protected List<ReferenceType> variableReference;

    /**
     * References the variable containing the conditional content, provides the value of the condition.
     *
     * @return possible object is
     * {@link ConditionalVariableReferenceType }
     */
    public ConditionalVariableReferenceType getConditionalVariableReference() {
        return conditionalVariableReference;
    }

    /**
     * Sets the value of the conditionalVariableReference property.
     *
     * @param value allowed object is
     *              {@link ConditionalVariableReferenceType }
     */
    public void setConditionalVariableReference(ConditionalVariableReferenceType value) {
        this.conditionalVariableReference = value;
    }

    /**
     * The variables required to provide a unique identification when the conditional variable contains the stated value.Gets the value of the variableReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getVariableReference() {
        if (variableReference == null) {
            variableReference = new ArrayList<ReferenceType>();
        }
        return this.variableReference;
    }

}
