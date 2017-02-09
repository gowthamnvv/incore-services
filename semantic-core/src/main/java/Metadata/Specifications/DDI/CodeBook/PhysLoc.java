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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physLocType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="physLocType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="recRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="startPos" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="endPos" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physLocType")
@XmlRootElement(name = "physLoc")
public class PhysLoc
        extends BaseElementType {

    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "recRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object recRef;
    @XmlAttribute(name = "startPos")
    protected String startPos;
    @XmlAttribute(name = "width")
    protected String width;
    @XmlAttribute(name = "endPos")
    protected String endPos;

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

    /**
     * Gets the value of the recRef property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getRecRef() {
        return recRef;
    }

    /**
     * Sets the value of the recRef property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setRecRef(Object value) {
        this.recRef = value;
    }

    /**
     * Gets the value of the startPos property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStartPos() {
        return startPos;
    }

    /**
     * Sets the value of the startPos property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStartPos(String value) {
        this.startPos = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the endPos property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEndPos() {
        return endPos;
    }

    /**
     * Sets the value of the endPos property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEndPos(String value) {
        this.endPos = value;
    }

}
