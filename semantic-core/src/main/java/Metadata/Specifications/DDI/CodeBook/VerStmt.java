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
 * <p>Java class for verStmtType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="verStmtType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}version" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}verResp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}notes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verStmtType", propOrder = {
        "versions",
        "verResps",
        "notes"
})
@XmlRootElement(name = "verStmt")
public class VerStmt
        extends BaseElementType {

    @XmlElement(name = "version")
    protected List<Version> versions;
    @XmlElement(name = "verResp")
    protected List<VerResp> verResps;
    protected List<Notes> notes;

    /**
     * Gets the value of the versions property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versions property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersions().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Version }
     */
    public List<Version> getVersions() {
        if (versions == null) {
            versions = new ArrayList<Version>();
        }
        return this.versions;
    }

    /**
     * Gets the value of the verResps property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verResps property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerResps().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerResp }
     */
    public List<VerResp> getVerResps() {
        if (verResps == null) {
            verResps = new ArrayList<VerResp>();
        }
        return this.verResps;
    }

    /**
     * Gets the value of the notes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotes().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notes }
     */
    public List<Notes> getNotes() {
        if (notes == null) {
            notes = new ArrayList<Notes>();
        }
        return this.notes;
    }

}
