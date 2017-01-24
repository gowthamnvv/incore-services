//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.xHTML;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for h1.type complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="h1.type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;group ref="{http://www.w3.org/1999/xhtml}h1.content"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/1999/xhtml}h1.attlist"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "h1.type", propOrder = {"content"})
public class H1Type {

    @XmlElementRefs({
            @XmlElementRef(name = "big", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "br", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "dfn", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "q", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "bdo", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "strong", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "cite", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "acronym", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "small", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "span", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "em", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "kbd", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "sub", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "abbr", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "code", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "var", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "sup", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "samp", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "b", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "i", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "tt", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "a", namespace = "http://www.w3.org/1999/xhtml", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;

    @XmlAttribute(name = "dir")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dir;

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    @XmlAttribute(name = "title")
    protected String title;

    @XmlAttribute(name = "class")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> clazz;

    @XmlAttribute(name = "style")
    protected String style;

    /**
     * Gets the value of the content property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link BrType }{@code >}
     * {@link JAXBElement }{@code <}{@link DfnType }{@code >}
     * {@link JAXBElement }{@code <}{@link QType }{@code >}
     * {@link JAXBElement }{@code <}{@link BdoType }{@code >}
     * {@link JAXBElement }{@code <}{@link StrongType }{@code >}
     * {@link JAXBElement }{@code <}{@link CiteType }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link AcronymType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link SpanType }{@code >}
     * {@link JAXBElement }{@code <}{@link EmType }{@code >}
     * {@link JAXBElement }{@code <}{@link KbdType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbbrType }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link VarType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link SampType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link InlPresType }{@code >}
     * {@link JAXBElement }{@code <}{@link AType }{@code >}
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the dir property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDir(String value) {
        this.dir = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the clazz property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clazz property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClazz().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getClazz() {
        if (clazz == null) {
            clazz = new ArrayList<String>();
        }
        return this.clazz;
    }

    /**
     * Gets the value of the style property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStyle(String value) {
        this.style = value;
    }

}
