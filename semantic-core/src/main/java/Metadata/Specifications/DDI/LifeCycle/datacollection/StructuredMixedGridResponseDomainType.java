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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains a mixture of response domains for the grid cells. Each response domain can be attached to a specific region of the grid, for example a single column or row. It is assumed that each cell will contain either a resonse domain or be declared as containing No Data By Definition. Any cell may also contain an internal label.
 * <p>
 * <p>Java class for StructuredMixedGridResponseDomainType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="StructuredMixedGridResponseDomainType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:datacollection:3_2}GridResponseDomain"/&gt;
 *           &lt;element ref="{ddi:datacollection:3_2}NoDataByDefinition"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredMixedGridResponseDomainType", propOrder = {
        "gridResponseDomainOrNoDataByDefinition"
})
public class StructuredMixedGridResponseDomainType {

    @XmlElements({
            @XmlElement(name = "GridResponseDomain", type = GridResponseDomainType.class),
            @XmlElement(name = "NoDataByDefinition", type = GridAttachmentType.class)
    })
    protected List<Object> gridResponseDomainOrNoDataByDefinition;

    /**
     * Gets the value of the gridResponseDomainOrNoDataByDefinition property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gridResponseDomainOrNoDataByDefinition property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGridResponseDomainOrNoDataByDefinition().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GridResponseDomainType }
     * {@link GridAttachmentType }
     */
    public List<Object> getGridResponseDomainOrNoDataByDefinition() {
        if (gridResponseDomainOrNoDataByDefinition == null) {
            gridResponseDomainOrNoDataByDefinition = new ArrayList<Object>();
        }
        return this.gridResponseDomainOrNoDataByDefinition;
    }

}
