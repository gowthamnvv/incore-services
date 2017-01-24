//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.conceptualcomponent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.MaintainableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.SchemeReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * A comprehensive list of the ConceptualVariables measured by the data that are being documented and/or maintained by an agency. In addition to the standard name, label, and description, allows for the inclusion of an existing ConceptualVariableScheme by reference, the inclusion of descriptions for ConceptualVariables and ConceptualVariableGroups in-line or by reference.
 * <p>
 * <p>Java class for ConceptualVariableSchemeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ConceptualVariableSchemeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}MaintainableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptualVariableSchemeName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ConceptualVariableSchemeReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptualVariable"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}ConceptualVariableReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptualVariableGroup"/&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}ConceptualVariableGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptualVariableSchemeType", propOrder = {
        "conceptualVariableSchemeName",
        "label",
        "description",
        "conceptualVariableSchemeReference",
        "conceptualVariableOrConceptualVariableReference",
        "conceptualVariableGroupOrConceptualVariableGroupReference"
})
public class ConceptualVariableSchemeType
        extends MaintainableType {

    @XmlElement(name = "ConceptualVariableSchemeName")
    protected List<NameType> conceptualVariableSchemeName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "ConceptualVariableSchemeReference", namespace = "ddi:reusable:3_2")
    protected List<SchemeReferenceType> conceptualVariableSchemeReference;
    @XmlElements({
            @XmlElement(name = "ConceptualVariable", type = ConceptualVariableType.class),
            @XmlElement(name = "ConceptualVariableReference", namespace = "ddi:reusable:3_2", type = ReferenceType.class)
    })
    protected List<Object> conceptualVariableOrConceptualVariableReference;
    @XmlElements({
            @XmlElement(name = "ConceptualVariableGroup", type = ConceptualVariableGroupType.class),
            @XmlElement(name = "ConceptualVariableGroupReference", type = ReferenceType.class)
    })
    protected List<Object> conceptualVariableGroupOrConceptualVariableGroupReference;

    /**
     * A name for the ConceptualVariableScheme. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the conceptualVariableSchemeName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptualVariableSchemeName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptualVariableSchemeName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getConceptualVariableSchemeName() {
        if (conceptualVariableSchemeName == null) {
            conceptualVariableSchemeName = new ArrayList<NameType>();
        }
        return this.conceptualVariableSchemeName;
    }

    /**
     * A display label for the ConceptualVariableScheme. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
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
     * A description of the ConceptualVariableScheme. May be expressed in multiple languages and supports the use of structured content.
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
     * Reference to an existing ConceptualVariableScheme for inclusion. TypeOfObject should be set to a ConceptualVariableScheme.Gets the value of the conceptualVariableSchemeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptualVariableSchemeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptualVariableSchemeReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeReferenceType }
     */
    public List<SchemeReferenceType> getConceptualVariableSchemeReference() {
        if (conceptualVariableSchemeReference == null) {
            conceptualVariableSchemeReference = new ArrayList<SchemeReferenceType>();
        }
        return this.conceptualVariableSchemeReference;
    }

    /**
     * Gets the value of the conceptualVariableOrConceptualVariableReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptualVariableOrConceptualVariableReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptualVariableOrConceptualVariableReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConceptualVariableType }
     * {@link ReferenceType }
     */
    public List<Object> getConceptualVariableOrConceptualVariableReference() {
        if (conceptualVariableOrConceptualVariableReference == null) {
            conceptualVariableOrConceptualVariableReference = new ArrayList<Object>();
        }
        return this.conceptualVariableOrConceptualVariableReference;
    }

    /**
     * Gets the value of the conceptualVariableGroupOrConceptualVariableGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conceptualVariableGroupOrConceptualVariableGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConceptualVariableGroupOrConceptualVariableGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConceptualVariableGroupType }
     * {@link ReferenceType }
     */
    public List<Object> getConceptualVariableGroupOrConceptualVariableGroupReference() {
        if (conceptualVariableGroupOrConceptualVariableGroupReference == null) {
            conceptualVariableGroupOrConceptualVariableGroupReference = new ArrayList<Object>();
        }
        return this.conceptualVariableGroupOrConceptualVariableGroupReference;
    }

}
