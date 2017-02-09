//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.group;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeGroupCodeType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimeGroupCodeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="T0"/&gt;
 *     &lt;enumeration value="T1"/&gt;
 *     &lt;enumeration value="T2"/&gt;
 *     &lt;enumeration value="T3"/&gt;
 *     &lt;enumeration value="T4"/&gt;
 *     &lt;enumeration value="T5"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TimeGroupCodeType")
@XmlEnum
public enum TimeGroupCodeType {


    /**
     * No specified relationship
     */
    @XmlEnumValue("T0")
    T_0("T0"),

    /**
     * Single Occurrence
     */
    @XmlEnumValue("T1")
    T_1("T1"),

    /**
     * Multiple Occurrence: Regular Occurrence: Continuing
     */
    @XmlEnumValue("T2")
    T_2("T2"),

    /**
     * Multiple Occurrence: Regular Occurrence: Limited time
     */
    @XmlEnumValue("T3")
    T_3("T3"),

    /**
     * Multiple Occurrence: Irregular Occurrence: Continuing
     */
    @XmlEnumValue("T4")
    T_4("T4"),

    /**
     * Multiple Occurrence: Irregular Occurrence: Limited time
     */
    @XmlEnumValue("T5")
    T_5("T5");
    private final String value;

    TimeGroupCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeGroupCodeType fromValue(String v) {
        for (TimeGroupCodeType c : TimeGroupCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
