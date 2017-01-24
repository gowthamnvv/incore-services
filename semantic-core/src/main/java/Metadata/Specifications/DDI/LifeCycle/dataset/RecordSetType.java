//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.dataset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Storage format arranged record by record. A RecordSet requires a list of variables to appear in a specified order. Provides a consistent order for the variables and a set of values for each record displayed in variable order.
 * <p>
 * <p>Java class for RecordSetType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RecordSetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:dataset:3_2}VariableOrder" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:dataset:3_2}Record" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordSetType", propOrder = {
        "variableOrder",
        "record"
})
public class RecordSetType {

    @XmlElement(name = "VariableOrder")
    protected VariableOrderType variableOrder;
    @XmlElement(name = "Record", required = true)
    protected List<RecordType> record;

    /**
     * Provides the sequence of variables representing the order of storage within each record.
     *
     * @return possible object is
     * {@link VariableOrderType }
     */
    public VariableOrderType getVariableOrder() {
        return variableOrder;
    }

    /**
     * Sets the value of the variableOrder property.
     *
     * @param value allowed object is
     *              {@link VariableOrderType }
     */
    public void setVariableOrder(VariableOrderType value) {
        this.variableOrder = value;
    }

    /**
     * For each record, contains the values for the items in order by the specified variable sequence.Gets the value of the record property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordType }
     */
    public List<RecordType> getRecord() {
        if (record == null) {
            record = new ArrayList<RecordType>();
        }
        return this.record;
    }

}
