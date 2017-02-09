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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for entryType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="entryType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;ddi:codebook:2_5&gt;stringType"&gt;
 *       &lt;attribute name="colname" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="namest" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="nameend" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="morerows" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="colsep" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rowsep" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="align"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="left"/&gt;
 *             &lt;enumeration value="right"/&gt;
 *             &lt;enumeration value="center"/&gt;
 *             &lt;enumeration value="justify"/&gt;
 *             &lt;enumeration value="char"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="char" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="charoff" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="valign"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="top"/&gt;
 *             &lt;enumeration value="middle"/&gt;
 *             &lt;enumeration value="bottom"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entryType")
@XmlRootElement(name = "entry")
public class Entry
        extends StringType {

    @XmlAttribute(name = "colname")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String colname;
    @XmlAttribute(name = "namest")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String namest;
    @XmlAttribute(name = "nameend")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String nameend;
    @XmlAttribute(name = "morerows")
    protected String morerows;
    @XmlAttribute(name = "colsep")
    protected String colsep;
    @XmlAttribute(name = "rowsep")
    protected String rowsep;
    @XmlAttribute(name = "align")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String align;
    @XmlAttribute(name = "char")
    protected String _char;
    @XmlAttribute(name = "charoff")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String charoff;
    @XmlAttribute(name = "valign")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String valign;

    /**
     * Gets the value of the colname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getColname() {
        return colname;
    }

    /**
     * Sets the value of the colname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setColname(String value) {
        this.colname = value;
    }

    /**
     * Gets the value of the namest property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNamest() {
        return namest;
    }

    /**
     * Sets the value of the namest property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNamest(String value) {
        this.namest = value;
    }

    /**
     * Gets the value of the nameend property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNameend() {
        return nameend;
    }

    /**
     * Sets the value of the nameend property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNameend(String value) {
        this.nameend = value;
    }

    /**
     * Gets the value of the morerows property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMorerows() {
        return morerows;
    }

    /**
     * Sets the value of the morerows property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMorerows(String value) {
        this.morerows = value;
    }

    /**
     * Gets the value of the colsep property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getColsep() {
        return colsep;
    }

    /**
     * Sets the value of the colsep property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setColsep(String value) {
        this.colsep = value;
    }

    /**
     * Gets the value of the rowsep property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRowsep() {
        return rowsep;
    }

    /**
     * Sets the value of the rowsep property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRowsep(String value) {
        this.rowsep = value;
    }

    /**
     * Gets the value of the align property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the char property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChar() {
        return _char;
    }

    /**
     * Sets the value of the char property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChar(String value) {
        this._char = value;
    }

    /**
     * Gets the value of the charoff property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCharoff() {
        return charoff;
    }

    /**
     * Sets the value of the charoff property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCharoff(String value) {
        this.charoff = value;
    }

    /**
     * Gets the value of the valign property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValign() {
        return valign;
    }

    /**
     * Sets the value of the valign property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValign(String value) {
        this.valign = value;
    }

}
