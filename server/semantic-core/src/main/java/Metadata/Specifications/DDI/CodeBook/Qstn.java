//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Metadata.Specifications.DDI.xHTML.*;

/**
 * <p>Java class for qstnType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="qstnType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}abstractTextType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;group ref="{ddi:codebook:2_5}PHRASE"/&gt;
 *           &lt;group ref="{ddi:codebook:2_5}FORM"/&gt;
 *           &lt;group ref="{http://www.w3.org/1999/xhtml}BlkNoForm.mix"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}preQTxt"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}qstnLit"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}postQTxt"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}forward"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}backward"/&gt;
 *           &lt;element ref="{ddi:codebook:2_5}ivuInstr"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="qstn" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="var" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *       &lt;attribute name="seqNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="sdatrefs" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *       &lt;attribute name="responseDomainType"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="text"/&gt;
 *             &lt;enumeration value="numeric"/&gt;
 *             &lt;enumeration value="code"/&gt;
 *             &lt;enumeration value="category"/&gt;
 *             &lt;enumeration value="datetime"/&gt;
 *             &lt;enumeration value="geographic"/&gt;
 *             &lt;enumeration value="multiple"/&gt;
 *             &lt;enumeration value="other"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="otherResponseDomainType" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "qstnType", propOrder = {
        "extLinksAndLinksAndDivs"
})
@XmlRootElement(name = "qstn")
public class Qstn extends AbstractTextType {

    @XmlElementRefs({
            @XmlElementRef(name = "h1", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "dl", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "h4", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "h5", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "ul", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "pre", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "div", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "h2", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "blockquote", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "h6", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "h3", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "p", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "hr", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "ol", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "table", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "address", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),

            @XmlElementRef(name = "emph", namespace = "ddi:codebook:2_5", type = Emph.class, required = false),
            @XmlElementRef(name = "Link", namespace = "ddi:codebook:2_5", type = Link.class, required = false),
            @XmlElementRef(name = "ivuInstr", namespace = "ddi:codebook:2_5", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "backward", namespace = "ddi:codebook:2_5", type = Backward.class, required = false),
            @XmlElementRef(name = "head", namespace = "ddi:codebook:2_5", type = Head.class, required = false),
            @XmlElementRef(name = "list", namespace = "ddi:codebook:2_5", type = List.class, required = false),
            @XmlElementRef(name = "forward", namespace = "ddi:codebook:2_5", type = Forward.class, required = false),
            @XmlElementRef(name = "ExtLink", namespace = "ddi:codebook:2_5", type = ExtLink.class, required = false),
            @XmlElementRef(name = "preQTxt", namespace = "ddi:codebook:2_5", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "postQTxt", namespace = "ddi:codebook:2_5", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "hi", namespace = "ddi:codebook:2_5", type = Hi.class, required = false),
            @XmlElementRef(name = "qstnLit", namespace = "ddi:codebook:2_5", type = QstnLit.class, required = false),
            @XmlElementRef(name = "div", namespace = "ddi:codebook:2_5", type = Div.class, required = false),
            @XmlElementRef(name = "p", namespace = "ddi:codebook:2_5", type = P.class, required = false)
    })
    protected java.util.List<Object> extLinksAndLinksAndDivs;

    @XmlAttribute(name = "qstn")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object qstn;

    @XmlAttribute(name = "var")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected java.util.List<Object> vars;

    @XmlAttribute(name = "seqNo")
    protected String seqNo;

    @XmlAttribute(name = "sdatrefs")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected java.util.List<Object> sdatrefs;

    @XmlAttribute(name = "responseDomainType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String responseDomainType;

    @XmlAttribute(name = "otherResponseDomainType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String otherResponseDomainType;

    /**
     * Gets the value of the extLinksAndLinksAndDivs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extLinksAndLinksAndDivs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtLinksAndLinksAndDivs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link H1Type }
     * {@link DlType }
     * {@link H4Type }
     * {@link H5Type }
     * {@link UlType }
     * {@link PreType }
     * {@link DivType }
     * {@link H2Type }
     * {@link BlockquoteType }
     * {@link H6Type }
     * {@link H3Type }
     * {@link PType }
     * {@link HrType }
     * {@link OlType }
     * {@link TableType }
     * {@link AddressType }
     * <p>
     * {@link Emph }
     * {@link Link }
     * {@link JAXBElement }{@code <}{@link SimpleTextType }{@code >}
     * {@link Backward }
     * {@link Head }
     * {@link List }
     * {@link Forward }
     * {@link ExtLink }
     * {@link JAXBElement }{@code <}{@link SimpleTextType }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleTextType }{@code >}
     * {@link Hi }
     * {@link QstnLit }
     * {@link Div }
     * {@link P }
     */
    public java.util.List<Object> getExtLinksAndLinksAndDivs() {
        if (extLinksAndLinksAndDivs == null) {
            extLinksAndLinksAndDivs = new ArrayList<Object>();
        }
        return this.extLinksAndLinksAndDivs;
    }

    /**
     * Gets the value of the qstn property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getQstn() {
        return qstn;
    }

    /**
     * Sets the value of the qstn property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setQstn(Object value) {
        this.qstn = value;
    }

    /**
     * Gets the value of the vars property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vars property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVars().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public java.util.List<Object> getVars() {
        if (vars == null) {
            vars = new ArrayList<Object>();
        }
        return this.vars;
    }

    /**
     * Gets the value of the seqNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * Sets the value of the seqNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSeqNo(String value) {
        this.seqNo = value;
    }

    /**
     * Gets the value of the sdatrefs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdatrefs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSdatrefs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public java.util.List<Object> getSdatrefs() {
        if (sdatrefs == null) {
            sdatrefs = new ArrayList<Object>();
        }
        return this.sdatrefs;
    }

    /**
     * Gets the value of the responseDomainType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResponseDomainType() {
        return responseDomainType;
    }

    /**
     * Sets the value of the responseDomainType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResponseDomainType(String value) {
        this.responseDomainType = value;
    }

    /**
     * Gets the value of the otherResponseDomainType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOtherResponseDomainType() {
        return otherResponseDomainType;
    }

    /**
     * Sets the value of the otherResponseDomainType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOtherResponseDomainType(String value) {
        this.otherResponseDomainType = value;
    }

}