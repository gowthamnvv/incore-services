//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.ncube.tabular;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.BaseRecordLayoutType;
import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;


/**
 * A member of the BaseRecordLayout substitution group intended for use with tabular formats of NCube Instances held in an external file with location for data items arranged as two-dimensional rows (identified by row and column). In addition to the link to the PhysicalStructure provided by BaseRecordLayout, the record layout is this namespace (m3) identifies the character set and array base for the stored data, a full description of each data item contained within an NCube Instance including a link to its description (matrix address) and its physical location in the file.
 * <p>
 * <p>Java class for RecordLayoutType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RecordLayoutType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:physicaldataproduct:3_2}BaseRecordLayoutType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}CharacterSet" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ArrayBase"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:physicaldataproduct_ncube_tabular:3_2}NCubeInstance"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}NCubeInstanceReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{ddi:physicaldataproduct_ncube_tabular:3_2}TopLeftTableAnchor" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordLayoutType", propOrder = {
        "characterSet",
        "arrayBase",
        "nCubeInstanceOrNCubeInstanceReference",
        "topLeftTableAnchor"
})
public class RecordLayoutType
        extends BaseRecordLayoutType {

    @XmlElement(name = "CharacterSet", namespace = "ddi:reusable:3_2")
    protected CodeValueType characterSet;
    @XmlElement(name = "ArrayBase", namespace = "ddi:reusable:3_2", required = true)
    protected BigInteger arrayBase;
    @XmlElements({
            @XmlElement(name = "NCubeInstance", type = NCubeInstanceType.class),
            @XmlElement(name = "NCubeInstanceReference", namespace = "ddi:reusable:3_2", type = ReferenceType.class)
    })
    protected List<Object> nCubeInstanceOrNCubeInstanceReference;
    @XmlElement(name = "TopLeftTableAnchor")
    protected TopLeftTableAnchorType topLeftTableAnchor;

    /**
     * Character set used in the data file (e.g., US ASCII, EBCDIC, UTF-8). This is a required field.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getCharacterSet() {
        return characterSet;
    }

    /**
     * Sets the value of the characterSet property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setCharacterSet(CodeValueType value) {
        this.characterSet = value;
    }

    /**
     * Sets the array base for any arrays used in the definition (that is, whether the first value is in position 0 or 1, etc.). This may be the data array in a delimited data file or the measure array for measures that are bundled and stored in a single location. Array base is generally set to either 0 or 1. There is no override provided as systems processing a record would use a consistent array base.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getArrayBase() {
        return arrayBase;
    }

    /**
     * Sets the value of the arrayBase property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setArrayBase(BigInteger value) {
        this.arrayBase = value;
    }

    /**
     * Gets the value of the nCubeInstanceOrNCubeInstanceReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nCubeInstanceOrNCubeInstanceReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNCubeInstanceOrNCubeInstanceReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NCubeInstanceType }
     * {@link ReferenceType }
     */
    public List<Object> getNCubeInstanceOrNCubeInstanceReference() {
        if (nCubeInstanceOrNCubeInstanceReference == null) {
            nCubeInstanceOrNCubeInstanceReference = new ArrayList<Object>();
        }
        return this.nCubeInstanceOrNCubeInstanceReference;
    }

    /**
     * Notes the column and row position of the top left corner of the data table in the spreadsheet.
     *
     * @return possible object is
     * {@link TopLeftTableAnchorType }
     */
    public TopLeftTableAnchorType getTopLeftTableAnchor() {
        return topLeftTableAnchor;
    }

    /**
     * Sets the value of the topLeftTableAnchor property.
     *
     * @param value allowed object is
     *              {@link TopLeftTableAnchorType }
     */
    public void setTopLeftTableAnchor(TopLeftTableAnchorType value) {
        this.topLeftTableAnchor = value;
    }

}