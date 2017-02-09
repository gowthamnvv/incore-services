//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itmType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="itmType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}formType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;group ref="{ddi:codebook:2_5}PHRASE"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}emph"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}hi"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}list"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}p"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}label"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itmType", propOrder = {
        "extLinksAndLinksAndEmphs"
})
@XmlRootElement(name = "itm")
public class Itm
        extends FormType {

    @XmlElements({
            @XmlElement(name = "ExtLink", type = ExtLink.class),
            @XmlElement(name = "Link", type = Link.class),
            @XmlElement(name = "emph", type = Emph.class),
            @XmlElement(name = "hi", type = Hi.class),
            @XmlElement(name = "list", type = List.class),
            @XmlElement(name = "p", type = P.class),
            @XmlElement(name = "label", type = Label.class)
    })
    protected java.util.List<BaseElementType> extLinksAndLinksAndEmphs;

    /**
     * Gets the value of the extLinksAndLinksAndEmphs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extLinksAndLinksAndEmphs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtLinksAndLinksAndEmphs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtLink }
     * {@link Link }
     * {@link Emph }
     * {@link Hi }
     * {@link List }
     * {@link P }
     * {@link Label }
     */
    public java.util.List<BaseElementType> getExtLinksAndLinksAndEmphs() {
        if (extLinksAndLinksAndEmphs == null) {
            extLinksAndLinksAndEmphs = new ArrayList<BaseElementType>();
        }
        return this.extLinksAndLinksAndEmphs;
    }

}
