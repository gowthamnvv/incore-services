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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.SchemeReferenceType;


/**
 * Identifies the variables contained in the logical record by indicating that all variable contained in the logical product are included, inclusion of a scheme of variable to include, or listing individual variables to include. When the attribute allVariablesInLogicalProduct is set to "false" use the VariableSchemeReference (which allows for exclusions) and VariableUsedReference to specify the included variables.
 * <p>
 * <p>Java class for VariablesInRecordType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="VariablesInRecordType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}VariableSchemeReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:logicalproduct:3_2}VariableUsedReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="allVariablesInLogicalProduct" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariablesInRecordType", propOrder = {
        "variableSchemeReference",
        "variableUsedReference"
})
public class VariablesInRecordType {

    @XmlElement(name = "VariableSchemeReference", namespace = "ddi:reusable:3_2")
    protected List<SchemeReferenceType> variableSchemeReference;
    @XmlElement(name = "VariableUsedReference")
    protected List<ReferenceType> variableUsedReference;
    @XmlAttribute(name = "allVariablesInLogicalProduct")
    protected Boolean allVariablesInLogicalProduct;

    /**
     * Reference to a VariableScheme whose members are included in the logical record. Note that individual items may be excluded from the scheme if not used by the logical record.Gets the value of the variableSchemeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableSchemeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableSchemeReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeReferenceType }
     */
    public List<SchemeReferenceType> getVariableSchemeReference() {
        if (variableSchemeReference == null) {
            variableSchemeReference = new ArrayList<SchemeReferenceType>();
        }
        return this.variableSchemeReference;
    }

    /**
     * Reference to a variable to include in the logical record. This may be used to supplement the contents of an included VariableScheme or to list all the variables individually.Gets the value of the variableUsedReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableUsedReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableUsedReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getVariableUsedReference() {
        if (variableUsedReference == null) {
            variableUsedReference = new ArrayList<ReferenceType>();
        }
        return this.variableUsedReference;
    }

    /**
     * Gets the value of the allVariablesInLogicalProduct property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isAllVariablesInLogicalProduct() {
        return allVariablesInLogicalProduct;
    }

    /**
     * Sets the value of the allVariablesInLogicalProduct property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setAllVariablesInLogicalProduct(Boolean value) {
        this.allVariablesInLogicalProduct = value;
    }

}
