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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setAvailType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="setAvailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}accsPlac" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}origArch" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}avlStatus" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}collSize" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}complete" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}fileQnty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}notes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="media" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="callno" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setAvailType", propOrder = {
        "accsPlacs",
        "origArches",
        "avlStatuses",
        "collSizes",
        "completes",
        "fileQnties",
        "notes"
})
@XmlRootElement(name = "setAvail")
public class SetAvail
        extends BaseElementType {

    @XmlElement(name = "accsPlac")
    protected List<AccsPlac> accsPlacs;
    @XmlElement(name = "origArch")
    protected List<SimpleTextType> origArches;
    @XmlElement(name = "avlStatus")
    protected List<SimpleTextType> avlStatuses;
    @XmlElement(name = "collSize")
    protected List<SimpleTextType> collSizes;
    @XmlElement(name = "complete")
    protected List<SimpleTextType> completes;
    @XmlElement(name = "fileQnty")
    protected List<SimpleTextType> fileQnties;
    protected List<Notes> notes;
    @XmlAttribute(name = "media")
    protected String media;
    @XmlAttribute(name = "callno")
    protected String callno;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the accsPlacs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accsPlacs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccsPlacs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccsPlac }
     */
    public List<AccsPlac> getAccsPlacs() {
        if (accsPlacs == null) {
            accsPlacs = new ArrayList<AccsPlac>();
        }
        return this.accsPlacs;
    }

    /**
     * Gets the value of the origArches property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the origArches property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrigArches().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getOrigArches() {
        if (origArches == null) {
            origArches = new ArrayList<SimpleTextType>();
        }
        return this.origArches;
    }

    /**
     * Gets the value of the avlStatuses property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avlStatuses property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvlStatuses().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getAvlStatuses() {
        if (avlStatuses == null) {
            avlStatuses = new ArrayList<SimpleTextType>();
        }
        return this.avlStatuses;
    }

    /**
     * Gets the value of the collSizes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collSizes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollSizes().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getCollSizes() {
        if (collSizes == null) {
            collSizes = new ArrayList<SimpleTextType>();
        }
        return this.collSizes;
    }

    /**
     * Gets the value of the completes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletes().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getCompletes() {
        if (completes == null) {
            completes = new ArrayList<SimpleTextType>();
        }
        return this.completes;
    }

    /**
     * Gets the value of the fileQnties property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileQnties property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileQnties().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getFileQnties() {
        if (fileQnties == null) {
            fileQnties = new ArrayList<SimpleTextType>();
        }
        return this.fileQnties;
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

    /**
     * Gets the value of the media property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMedia(String value) {
        this.media = value;
    }

    /**
     * Gets the value of the callno property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCallno() {
        return callno;
    }

    /**
     * Sets the value of the callno property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCallno(String value) {
        this.callno = value;
    }

    /**
     * Gets the value of the label property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

}