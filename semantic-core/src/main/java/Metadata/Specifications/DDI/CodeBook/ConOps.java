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


/**
 * <p>Java class for ConOpsType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ConOpsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}simpleTextType"&gt;
 *       &lt;attribute name="agency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConOpsType")
@XmlRootElement(name = "ConOps")
public class ConOps
        extends SimpleTextType {

    @XmlAttribute(name = "agency")
    protected String agency;

    /**
     * Gets the value of the agency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAgency() {
        return agency;
    }

    /**
     * Sets the value of the agency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAgency(String value) {
        this.agency = value;
    }

}
