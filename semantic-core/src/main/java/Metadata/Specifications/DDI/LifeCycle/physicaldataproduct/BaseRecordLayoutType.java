//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicaldataproduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.dataset.DataSetType;
import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.VersionableType;


/**
 * This type structures an abstract element which is used only as the head of a substitution group. It contains a reference to the Physical Structure that is available for use in all of the substitute RecordLayout structures.
 * <p>
 * <p>Java class for BaseRecordLayoutType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="BaseRecordLayoutType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}VersionableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}PhysicalStructureLinkReference"/&gt;
 *         &lt;element ref="{ddi:physicaldataproduct:3_2}EndOfLineMarker" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="textQualifier" type="{ddi:physicaldataproduct:3_2}TextQualifierType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRecordLayoutType", propOrder = {
        "physicalStructureLinkReference",
        "endOfLineMarker"
})
@XmlSeeAlso({
        DataSetType.class,
        Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.RecordLayoutType.class,
        Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.ncube.inline.RecordLayoutType.class,
        Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.ncube.normal.RecordLayoutType.class,
        Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.ncube.tabular.RecordLayoutType.class,
        Metadata.Specifications.DDI.LifeCycle.physicaldataproduct.proprietary.RecordLayoutType.class
})
public abstract class BaseRecordLayoutType
        extends VersionableType {

    @XmlElement(name = "PhysicalStructureLinkReference", required = true)
    protected PhysicalStructureLinkReferenceType physicalStructureLinkReference;
    @XmlElement(name = "EndOfLineMarker")
    protected CodeValueType endOfLineMarker;
    @XmlAttribute(name = "textQualifier")
    protected TextQualifierType textQualifier;

    /**
     * Reference to the PhysicalStructure and the PhysicalSegment used by this Record Layout.
     *
     * @return possible object is
     * {@link PhysicalStructureLinkReferenceType }
     */
    public PhysicalStructureLinkReferenceType getPhysicalStructureLinkReference() {
        return physicalStructureLinkReference;
    }

    /**
     * Sets the value of the physicalStructureLinkReference property.
     *
     * @param value allowed object is
     *              {@link PhysicalStructureLinkReferenceType }
     */
    public void setPhysicalStructureLinkReference(PhysicalStructureLinkReferenceType value) {
        this.physicalStructureLinkReference = value;
    }

    /**
     * Specifies the end-of-line (EOL) marker used in the file as produced. If no value is provided assume the use of a CRLF (carriage return and line feed). This is the common EOL for PC's. The common EOL in a Unix environment is LF. Some systems will automatically translate EOLs when a file is moved across systems. Common EOLs include: CR (carriage return), LF (line feed), CRLF, NEL (next line), VT (vertical tab), FF (form feed), LS (line separator) and PS (paragraph separator). See Part I documentation for more detailed information. This object supports the use of a controlled vocabulary. Use of a common controlled vocabulary is strongly recommended.
     *
     * @return possible object is
     * {@link CodeValueType }
     */
    public CodeValueType getEndOfLineMarker() {
        return endOfLineMarker;
    }

    /**
     * Sets the value of the endOfLineMarker property.
     *
     * @param value allowed object is
     *              {@link CodeValueType }
     */
    public void setEndOfLineMarker(CodeValueType value) {
        this.endOfLineMarker = value;
    }

    /**
     * Gets the value of the textQualifier property.
     *
     * @return possible object is
     * {@link TextQualifierType }
     */
    public TextQualifierType getTextQualifier() {
        return textQualifier;
    }

    /**
     * Sets the value of the textQualifier property.
     *
     * @param value allowed object is
     *              {@link TextQualifierType }
     */
    public void setTextQualifier(TextQualifierType value) {
        this.textQualifier = value;
    }

}
