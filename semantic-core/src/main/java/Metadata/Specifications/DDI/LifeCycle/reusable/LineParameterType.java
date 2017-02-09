//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specification of the line and offset for the beginning and end of the segment.
 * <p>
 * <p>Java class for LineParameterType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="LineParameterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StartLine" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="StartOffset" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="EndLine" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="EndOffset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineParameterType", propOrder = {
        "startLine",
        "startOffset",
        "endLine",
        "endOffset"
})
public class LineParameterType {

    @XmlElement(name = "StartLine", required = true, defaultValue = "0")
    protected BigInteger startLine;
    @XmlElement(name = "StartOffset", required = true, defaultValue = "0")
    protected BigInteger startOffset;
    @XmlElement(name = "EndLine")
    protected BigInteger endLine;
    @XmlElement(name = "EndOffset")
    protected BigInteger endOffset;

    /**
     * Gets the value of the startLine property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getStartLine() {
        return startLine;
    }

    /**
     * Sets the value of the startLine property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setStartLine(BigInteger value) {
        this.startLine = value;
    }

    /**
     * Gets the value of the startOffset property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getStartOffset() {
        return startOffset;
    }

    /**
     * Sets the value of the startOffset property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setStartOffset(BigInteger value) {
        this.startOffset = value;
    }

    /**
     * Gets the value of the endLine property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getEndLine() {
        return endLine;
    }

    /**
     * Sets the value of the endLine property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setEndLine(BigInteger value) {
        this.endLine = value;
    }

    /**
     * Gets the value of the endOffset property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getEndOffset() {
        return endOffset;
    }

    /**
     * Sets the value of the endOffset property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setEndOffset(BigInteger value) {
        this.endOffset = value;
    }

}
