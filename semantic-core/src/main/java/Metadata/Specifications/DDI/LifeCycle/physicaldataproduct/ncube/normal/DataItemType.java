//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.ncube.normal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Metadata.Specifications.DDI.LifeCycle.reusable.DimensionRankValueType;


/**
 * Describes a single data item or cell within an NCube Instance. It defines its location within the NCube by its coordinate (matrix) address which is its intersect point on each dimension. Allows for the specification of data item specific attributes, and identifies the physical location of each measure for the data item. May optionally indicate the language of the data contents.
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
 *         &lt;element ref="{ddi:reusable:3_2}DimensionRankValue" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{ddi:physicaldataproduct_ncube_normal:3_2}AttachedAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:physicaldataproduct_ncube_normal:3_2}Measure" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataItemType", propOrder = {
        "dimensionRankValue",
        "attachedAttribute",
        "measure"
})
public class DataItemType {

    @XmlElement(name = "DimensionRankValue", namespace = "ddi:reusable:3_2", required = true)
    protected List<DimensionRankValueType> dimensionRankValue;
    @XmlElement(name = "AttachedAttribute")
    protected List<AttachedAttributeType> attachedAttribute;
    @XmlElement(name = "Measure", required = true)
    protected List<MeasureType> measure;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;

    /**
     * A dimension describes the rank or order of the dimension within the NCube structure and provides the specific coordinate value of the dimension for the data item.Gets the value of the dimensionRankValue property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimensionRankValue property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimensionRankValue().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionRankValueType }
     */
    public List<DimensionRankValueType> getDimensionRankValue() {
        if (dimensionRankValue == null) {
            dimensionRankValue = new ArrayList<DimensionRankValueType>();
        }
        return this.dimensionRankValue;
    }

    /**
     * This is an attribute attached to the specified Data Item. The content of the attribute can be provided as a single value or reference a location in the data store where the attribute value will be found. This may be in addition to attribute information described in the logical structure.Gets the value of the attachedAttribute property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachedAttribute property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachedAttribute().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachedAttributeType }
     */
    public List<AttachedAttributeType> getAttachedAttribute() {
        if (attachedAttribute == null) {
            attachedAttribute = new ArrayList<AttachedAttributeType>();
        }
        return this.attachedAttribute;
    }

    /**
     * Identifies the specific measure of the cell by noting the order value of the measure within the MeasureDimension and provides information on the storage location of the cell value for the measure.Gets the value of the measure property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measure property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasure().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     */
    public List<MeasureType> getMeasure() {
        if (measure == null) {
            measure = new ArrayList<MeasureType>();
        }
        return this.measure;
    }

    /**
     * Use to indicate the language of the data item in the file.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
