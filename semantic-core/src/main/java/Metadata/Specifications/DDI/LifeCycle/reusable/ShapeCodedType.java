//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShapeCodedType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ShapeCodedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Rectangle"/&gt;
 *     &lt;enumeration value="Circle"/&gt;
 *     &lt;enumeration value="Polygon"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ShapeCodedType")
@XmlEnum
public enum ShapeCodedType {


    /**
     * A rectangular shape (4 sides, 90 degree angles) requiring a minimum of the four corner coordinates.
     */
    @XmlEnumValue("Rectangle")
    RECTANGLE("Rectangle"),

    /**
     * A circular shape requiring a centroid and radius.
     */
    @XmlEnumValue("Circle")
    CIRCLE("Circle"),

    /**
     * A non-rectangular polygon requiring three or more points to define.
     */
    @XmlEnumValue("Polygon")
    POLYGON("Polygon");
    private final String value;

    ShapeCodedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShapeCodedType fromValue(String v) {
        for (ShapeCodedType c : ShapeCodedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
