//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for timePrdType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="timePrdType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}simpleTextAndDateType"&gt;
 *       &lt;attribute name="event" default="single"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="start"/&gt;
 *             &lt;enumeration value="end"/&gt;
 *             &lt;enumeration value="single"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="cycle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timePrdType")
@XmlRootElement(name = "timePrd")
public class TimePrd
        extends SimpleTextAndDateType {

    @XmlAttribute(name = "event")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String event;
    @XmlAttribute(name = "cycle")
    protected String cycle;

    /**
     * Gets the value of the event property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEvent() {
        if (event == null) {
            return "single";
        } else {
            return event;
        }
    }

    /**
     * Sets the value of the event property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the cycle property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * Sets the value of the cycle property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCycle(String value) {
        this.cycle = value;
    }

}
