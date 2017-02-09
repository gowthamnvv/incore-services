//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A closed plane figure bounded by three or more line segments, representing a geographic area. Contains either the URI of the file containing the polygon, a specific link code for the shape within the file, and a file format, or a minimum of 4 points to describe the polygon in-line. Note that the first and last point must be identical in order to close the polygon. A triangle has 4 points. A geographic time designating the time period that the shape is valid should be included. If the date range is unknown use a SingleDate indicating a date that the shape was known to be valid.
 * <p>
 * <p>Java class for PolygonType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PolygonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="ExternalURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *             &lt;element name="PolygonLinkCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ShapeFileFormat" type="{ddi:reusable:3_2}CodeValueType" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{ddi:reusable:3_2}Point" maxOccurs="unbounded" minOccurs="4"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolygonType", propOrder = {
        "externalURI",
        "polygonLinkCode",
        "shapeFileFormat",
        "point"
})
public class PolygonType {

    @XmlElement(name = "ExternalURI")
    @XmlSchemaType(name = "anyURI")
    protected String externalURI;
    @XmlElement(name = "PolygonLinkCode")
    protected String polygonLinkCode;
    @XmlElement(name = "ShapeFileFormat")
    protected CodeValueType shapeFileFormat;
    @XmlElement(name = "Point")
    protected List<PointType> point;

    /**
     * Gets the value of the externalURI property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExternalURI() {
        return externalURI;
    }

    /**
     * Sets the value of the externalURI property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExternalURI(String value) {
        this.externalURI = value;
    }

    /**
     * Gets the value of the polygonLinkCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPolygonLinkCode() {
        return polygonLinkCode;
    }

    /**
     * Sets the value of the polygonLinkCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPolygonLinkCode(String value) {
        this.polygonLinkCode = value;
    }

    /**
     * Gets the value of the shapeFileFormat property.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getShapeFileFormat() {
        return shapeFileFormat;
    }

    /**
     * Sets the value of the shapeFileFormat property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setShapeFileFormat(CodeValueType value) {
        this.shapeFileFormat = value;
    }

    /**
     * A geographic point defined by a latitude and longitude. A minimum of 4 points is required as the first and last point should be identical in order to close the polygon. Note that a triangle has three sides and requires 3 unique points plus a fourth point replicating the first point in order to close the polygon.Gets the value of the point property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoint().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PointType }
     */
    public List<PointType> getPoint() {
        if (point == null) {
            point = new ArrayList<PointType>();
        }
        return this.point;
    }

}
