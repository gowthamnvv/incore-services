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
 * <p>Java class for othrStdyMatType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="othrStdyMatType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}relMat" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}relStdy" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}relPubl" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}othRefs" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "othrStdyMatType", propOrder = {
        "relMats",
        "relStdies",
        "relPubls",
        "othRefs"
})
@XmlRootElement(name = "othrStdyMat")
public class OthrStdyMat
        extends BaseElementType {

    @XmlElement(name = "relMat")
    protected List<RelMat> relMats;
    @XmlElement(name = "relStdy")
    protected List<MaterialReferenceType> relStdies;
    @XmlElement(name = "relPubl")
    protected List<MaterialReferenceType> relPubls;
    protected List<OthRefs> othRefs;

    /**
     * Gets the value of the relMats property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relMats property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelMats().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelMat }
     */
    public List<RelMat> getRelMats() {
        if (relMats == null) {
            relMats = new ArrayList<RelMat>();
        }
        return this.relMats;
    }

    /**
     * Gets the value of the relStdies property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relStdies property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelStdies().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaterialReferenceType }
     */
    public List<MaterialReferenceType> getRelStdies() {
        if (relStdies == null) {
            relStdies = new ArrayList<MaterialReferenceType>();
        }
        return this.relStdies;
    }

    /**
     * Gets the value of the relPubls property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relPubls property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelPubls().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaterialReferenceType }
     */
    public List<MaterialReferenceType> getRelPubls() {
        if (relPubls == null) {
            relPubls = new ArrayList<MaterialReferenceType>();
        }
        return this.relPubls;
    }

    /**
     * Gets the value of the othRefs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othRefs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthRefs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OthRefs }
     */
    public List<OthRefs> getOthRefs() {
        if (othRefs == null) {
            othRefs = new ArrayList<OthRefs>();
        }
        return this.othRefs;
    }

}
