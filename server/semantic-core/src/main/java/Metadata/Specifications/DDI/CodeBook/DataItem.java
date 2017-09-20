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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataItemType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="dataItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}CubeCoord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}physLoc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="varRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="nCubeRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataItemType", propOrder = {
        "cubeCoords",
        "physLocs"
})
@XmlRootElement(name = "dataItem")
public class DataItem
        extends BaseElementType {

    @XmlElement(name = "CubeCoord")
    protected List<CubeCoord> cubeCoords;
    @XmlElement(name = "physLoc")
    protected List<PhysLoc> physLocs;
    @XmlAttribute(name = "varRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object varRef;
    @XmlAttribute(name = "nCubeRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object nCubeRef;

    /**
     * Gets the value of the cubeCoords property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cubeCoords property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCubeCoords().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CubeCoord }
     */
    public List<CubeCoord> getCubeCoords() {
        if (cubeCoords == null) {
            cubeCoords = new ArrayList<CubeCoord>();
        }
        return this.cubeCoords;
    }

    /**
     * Gets the value of the physLocs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physLocs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysLocs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysLoc }
     */
    public List<PhysLoc> getPhysLocs() {
        if (physLocs == null) {
            physLocs = new ArrayList<PhysLoc>();
        }
        return this.physLocs;
    }

    /**
     * Gets the value of the varRef property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getVarRef() {
        return varRef;
    }

    /**
     * Sets the value of the varRef property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setVarRef(Object value) {
        this.varRef = value;
    }

    /**
     * Gets the value of the nCubeRef property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getNCubeRef() {
        return nCubeRef;
    }

    /**
     * Sets the value of the nCubeRef property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setNCubeRef(Object value) {
        this.nCubeRef = value;
    }

}