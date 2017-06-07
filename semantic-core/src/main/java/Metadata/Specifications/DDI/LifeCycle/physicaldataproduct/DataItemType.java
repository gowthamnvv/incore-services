//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;


/**
 * Describes a single data item within the record, linking its description in a variable to its physical location in the stored record.
 * <p>
 * <p>Java class for DataItemType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DataItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}VariableReference"/&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}PhysicalLocation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataItemType", propOrder = {
        "variableReference",
        "physicalLocation"
})
public class DataItemType {

    @XmlElement(name = "VariableReference", namespace = "ddi:reusable:3_2", required = true)
    protected ReferenceType variableReference;
    @XmlElement(name = "PhysicalLocation")
    protected PhysicalLocationType physicalLocation;

    /**
     * Reference to the Variable describing this data item.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getVariableReference() {
        return variableReference;
    }

    /**
     * Sets the value of the variableReference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setVariableReference(ReferenceType value) {
        this.variableReference = value;
    }

    /**
     * Description of the physical location of the value of the object in the data file.
     *
     * @return possible object is
     * {@link PhysicalLocationType }
     */
    public PhysicalLocationType getPhysicalLocation() {
        return physicalLocation;
    }

    /**
     * Sets the value of the physicalLocation property.
     *
     * @param value allowed object is
     *              {@link PhysicalLocationType }
     */
    public void setPhysicalLocation(PhysicalLocationType value) {
        this.physicalLocation = value;
    }

}