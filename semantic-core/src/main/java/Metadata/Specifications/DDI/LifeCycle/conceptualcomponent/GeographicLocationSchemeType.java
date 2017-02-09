//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.conceptualcomponent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.GeographicLocationReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.GeographicLocationType;
import Metadata.Specifications.DDI.LifeCycle.reusable.LabelType;
import Metadata.Specifications.DDI.LifeCycle.reusable.MaintainableType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.SchemeReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * A Scheme containing a set of geographic locations, each for a single Geography type, e.g., States, OR Counties, OR Countries, etc. The geographic location element has to be repeated for each geography. In addition to the standard name, label, and description, allows for the inclusion of an existing GeographicLocationScheme by reference and GeographicLocation descriptions either in-line or by reference.
 * <p>
 * <p>Java class for GeographicLocationSchemeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="GeographicLocationSchemeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}MaintainableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:conceptualcomponent:3_2}GeographicLocationSchemeName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Label" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}GeographicLocationSchemeReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:reusable:3_2}GeographicLocation"/&gt;
 *           &lt;element ref="{ddi:reusable:3_2}GeographicLocationReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}GeographicLocationGroup"/&gt;
 *           &lt;element ref="{ddi:conceptualcomponent:3_2}GeographicLocationGroupReference"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicLocationSchemeType", propOrder = {
        "geographicLocationSchemeName",
        "label",
        "description",
        "geographicLocationSchemeReference",
        "geographicLocationOrGeographicLocationReference",
        "geographicLocationGroupOrGeographicLocationGroupReference"
})
public class GeographicLocationSchemeType
        extends MaintainableType {

    @XmlElement(name = "GeographicLocationSchemeName")
    protected List<NameType> geographicLocationSchemeName;
    @XmlElement(name = "Label", namespace = "ddi:reusable:3_2")
    protected List<LabelType> label;
    @XmlElement(name = "Description", namespace = "ddi:reusable:3_2")
    protected StructuredStringType description;
    @XmlElement(name = "GeographicLocationSchemeReference", namespace = "ddi:reusable:3_2")
    protected List<SchemeReferenceType> geographicLocationSchemeReference;
    @XmlElements({
            @XmlElement(name = "GeographicLocation", namespace = "ddi:reusable:3_2", type = GeographicLocationType.class),
            @XmlElement(name = "GeographicLocationReference", namespace = "ddi:reusable:3_2", type = GeographicLocationReferenceType.class)
    })
    protected List<Object> geographicLocationOrGeographicLocationReference;
    @XmlElements({
            @XmlElement(name = "GeographicLocationGroup", type = GeographicLocationGroupType.class),
            @XmlElement(name = "GeographicLocationGroupReference", type = ReferenceType.class)
    })
    protected List<Object> geographicLocationGroupOrGeographicLocationGroupReference;

    /**
     * A name for the GeographicLocationScheme. May be expressed in multiple languages. Repeat the element to express names with different content, for example different names for different systems.Gets the value of the geographicLocationSchemeName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicLocationSchemeName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicLocationSchemeName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     */
    public List<NameType> getGeographicLocationSchemeName() {
        if (geographicLocationSchemeName == null) {
            geographicLocationSchemeName = new ArrayList<NameType>();
        }
        return this.geographicLocationSchemeName;
    }

    /**
     * A display label for the GeographicLocationScheme. May be expressed in multiple languages. Repeat for labels with different content, for example, labels with differing length limitations.Gets the value of the label property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the label property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabel().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LabelType }
     */
    public List<LabelType> getLabel() {
        if (label == null) {
            label = new ArrayList<LabelType>();
        }
        return this.label;
    }

    /**
     * A description of the GeographicLocationScheme. May be expressed in multiple languages and supports the use of Location content.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setDescription(StructuredStringType value) {
        this.description = value;
    }

    /**
     * Inclusion of an existing GeographicLocationScheme by reference.Gets the value of the geographicLocationSchemeReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicLocationSchemeReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicLocationSchemeReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeReferenceType }
     */
    public List<SchemeReferenceType> getGeographicLocationSchemeReference() {
        if (geographicLocationSchemeReference == null) {
            geographicLocationSchemeReference = new ArrayList<SchemeReferenceType>();
        }
        return this.geographicLocationSchemeReference;
    }

    /**
     * Gets the value of the geographicLocationOrGeographicLocationReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicLocationOrGeographicLocationReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicLocationOrGeographicLocationReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeographicLocationType }
     * {@link GeographicLocationReferenceType }
     */
    public List<Object> getGeographicLocationOrGeographicLocationReference() {
        if (geographicLocationOrGeographicLocationReference == null) {
            geographicLocationOrGeographicLocationReference = new ArrayList<Object>();
        }
        return this.geographicLocationOrGeographicLocationReference;
    }

    /**
     * Gets the value of the geographicLocationGroupOrGeographicLocationGroupReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicLocationGroupOrGeographicLocationGroupReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicLocationGroupOrGeographicLocationGroupReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeographicLocationGroupType }
     * {@link ReferenceType }
     */
    public List<Object> getGeographicLocationGroupOrGeographicLocationGroupReference() {
        if (geographicLocationGroupOrGeographicLocationGroupReference == null) {
            geographicLocationGroupOrGeographicLocationGroupReference = new ArrayList<Object>();
        }
        return this.geographicLocationGroupOrGeographicLocationGroupReference;
    }

}
