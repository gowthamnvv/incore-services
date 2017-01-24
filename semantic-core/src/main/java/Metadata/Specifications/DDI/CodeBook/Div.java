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
 * <p>Java class for divType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="divType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}formType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;group ref="{ddi:codebook:2_5}FORM"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divType", propOrder = {
        "divsAndEmphsAndHeads"
})
@XmlRootElement(name = "div")
public class Div
        extends FormType {

    @XmlElements({
            @XmlElement(name = "div", type = Div.class),
            @XmlElement(name = "emph", type = Emph.class),
            @XmlElement(name = "head", type = Head.class),
            @XmlElement(name = "hi", type = Hi.class),
            @XmlElement(name = "list", type = List.class),
            @XmlElement(name = "p", type = P.class)
    })
    protected java.util.List<FormType> divsAndEmphsAndHeads;

    /**
     * Gets the value of the divsAndEmphsAndHeads property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the divsAndEmphsAndHeads property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDivsAndEmphsAndHeads().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Div }
     * {@link Emph }
     * {@link Head }
     * {@link Hi }
     * {@link List }
     * {@link P }
     */
    public java.util.List<FormType> getDivsAndEmphsAndHeads() {
        if (divsAndEmphsAndHeads == null) {
            divsAndEmphsAndHeads = new ArrayList<FormType>();
        }
        return this.divsAndEmphsAndHeads;
    }

}
