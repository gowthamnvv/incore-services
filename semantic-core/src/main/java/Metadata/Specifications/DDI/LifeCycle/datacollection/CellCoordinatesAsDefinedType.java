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


/**
 * Defines one or more cells by defining the applicable values of each dimension as "all values", a "specific value" or a range. For example in a simple 2 dimensional grid where dimension rank-1 is displayed as rows and dimension rank-2 as columns and the first column contains a NumericDomain; SelectDimension rank="1" allValues="true" and SelectDimension rank="2" specificValue="1" would result in the NumericDomain being attached to the first column of the grid only.
 * <p>
 * <p>Java class for CellCoordinatesAsDefinedType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CellCoordinatesAsDefinedType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:datacollection:3_2}SelectDimension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CellCoordinatesAsDefinedType", propOrder = {
        "selectDimension"
})
public class CellCoordinatesAsDefinedType {

    @XmlElement(name = "SelectDimension")
    protected List<SelectDimensionType> selectDimension;

    /**
     * For each dimension in the grid define the applicable values as "all values", a "specific value" or a range. If a rangeMinimum or rangeMaximum is provided without the other, the assumption is unbounded for the object not included.Gets the value of the selectDimension property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectDimension property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectDimension().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SelectDimensionType }
     */
    public List<SelectDimensionType> getSelectDimension() {
        if (selectDimension == null) {
            selectDimension = new ArrayList<SelectDimensionType>();
        }
        return this.selectDimension;
    }

}
