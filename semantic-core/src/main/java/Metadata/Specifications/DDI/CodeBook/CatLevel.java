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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for catLevelType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="catLevelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;attribute name="levelnm" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="geoMap" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catLevelType")
@XmlRootElement(name = "catLevel")
public class CatLevel
        extends BaseElementType {

    @XmlAttribute(name = "levelnm")
    protected String levelnm;
    @XmlAttribute(name = "geoMap")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> geoMaps;

    /**
     * Gets the value of the levelnm property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLevelnm() {
        return levelnm;
    }

    /**
     * Sets the value of the levelnm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLevelnm(String value) {
        this.levelnm = value;
    }

    /**
     * Gets the value of the geoMaps property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoMaps property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeoMaps().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getGeoMaps() {
        if (geoMaps == null) {
            geoMaps = new ArrayList<Object>();
        }
        return this.geoMaps;
    }

}
