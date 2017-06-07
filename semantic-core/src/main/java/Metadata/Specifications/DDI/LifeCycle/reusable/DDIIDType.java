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
 * <p>Java class for DDIIDType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DDIIDType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Canonical"/&gt;
 *     &lt;enumeration value="Deprecated"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DDIIDType")
@XmlEnum
public enum DDIIDType {


    /**
     * The element uses the canonical format of the URN which includes urn:ddi:agency:id:version. The id may be scoped as unique to the agency or to the maintainable object. If the object is identifiable or versionable, and scoped to the maintainable object, the id is a combination of the maintainable id and the object id joined by a "." (period).
     */
    @XmlEnumValue("Canonical")
    CANONICAL("Canonical"),

    /**
     * The element used the deprecated format of the URN which includes urn:ddi:agency:TypeOfMaintainableObject:MaintainableId:TypeOfObject:ObjectId:ObjectVersion. Basically this is the same information as in the 3.0 and 3.1 DDI URN structures minus the Maintainable Version Number and using the ":" (colon) as a separator between each content part of the URN.
     */
    @XmlEnumValue("Deprecated")
    DEPRECATED("Deprecated");
    private final String value;

    DDIIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DDIIDType fromValue(String v) {
        for (DDIIDType c : DDIIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}