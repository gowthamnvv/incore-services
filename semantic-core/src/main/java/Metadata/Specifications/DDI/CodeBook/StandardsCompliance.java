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
 * <p>Java class for standardsComplianceType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="standardsComplianceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}standard"/&gt;
 *         &lt;element name="complianceDescription" type="{ddi:codebook:2_5}simpleTextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "standardsComplianceType", propOrder = {
        "standard",
        "complianceDescriptions"
})
@XmlRootElement(name = "standardsCompliance")
public class StandardsCompliance
        extends BaseElementType {

    @XmlElement(required = true)
    protected Standard standard;
    @XmlElement(name = "complianceDescription")
    protected List<SimpleTextType> complianceDescriptions;

    /**
     * Gets the value of the standard property.
     *
     * @return possible object is
     * {@link Standard }
     */
    public Standard getStandard() {
        return standard;
    }

    /**
     * Sets the value of the standard property.
     *
     * @param value allowed object is
     *              {@link Standard }
     */
    public void setStandard(Standard value) {
        this.standard = value;
    }

    /**
     * Gets the value of the complianceDescriptions property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complianceDescriptions property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplianceDescriptions().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getComplianceDescriptions() {
        if (complianceDescriptions == null) {
            complianceDescriptions = new ArrayList<SimpleTextType>();
        }
        return this.complianceDescriptions;
    }

}
