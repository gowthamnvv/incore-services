//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for boundPolyType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="boundPolyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}polygon" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boundPolyType", propOrder = {
        "polygons"
})
@XmlRootElement(name = "boundPoly")
public class BoundPoly
        extends BaseElementType {

    @XmlElement(name = "polygon", required = true)
    protected List<Polygon> polygons;

    /**
     * Gets the value of the polygons property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polygons property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolygons().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Polygon }
     */
    public List<Polygon> getPolygons() {
        if (polygons == null) {
            polygons = new ArrayList<Polygon>();
        }
        return this.polygons;
    }

}
