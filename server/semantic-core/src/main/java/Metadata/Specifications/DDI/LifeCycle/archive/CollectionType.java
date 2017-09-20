//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.archive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.CitationType;
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * Describes a collection of items held or distributed by the archive in connection with a study, group of studies, or resource packages. What constitutes an collection is determined by the archive. These may be data file(s) in a variety of formats, statistical setups, codebooks, questionnaires, etc. A collection may also be a group of studies, groups, and/or resource packages.
 * <p>
 * <p>Java class for CollectionType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CollectionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Citation" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}LocationInArchive" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}CallNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}URI" minOccurs="0"/&gt;
 *         &lt;element name="ItemQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}StudyClass" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}DefaultAccess" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}OriginalArchiveOrganizationReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}AvailabilityStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}DataFileQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}CollectionCompleteness" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}Item" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:archive:3_2}Collection" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectionType", propOrder = {
        "citation",
        "locationInArchive",
        "callNumber",
        "uri",
        "itemQuantity",
        "studyClass",
        "defaultAccess",
        "originalArchiveOrganizationReference",
        "availabilityStatus",
        "dataFileQuantity",
        "collectionCompleteness",
        "item",
        "collection"
})
public class CollectionType {

    @XmlElement(name = "Citation", namespace = "ddi:reusable:3_2")
    protected CitationType citation;
    @XmlElement(name = "LocationInArchive")
    protected List<InternationalStringType> locationInArchive;
    @XmlElement(name = "CallNumber")
    protected String callNumber;
    @XmlElement(name = "URI", namespace = "ddi:reusable:3_2")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlElement(name = "ItemQuantity")
    protected BigInteger itemQuantity;
    @XmlElement(name = "StudyClass")
    protected StudyClassType studyClass;
    @XmlElement(name = "DefaultAccess")
    protected AccessType defaultAccess;
    @XmlElement(name = "OriginalArchiveOrganizationReference")
    protected List<ReferenceType> originalArchiveOrganizationReference;
    @XmlElement(name = "AvailabilityStatus")
    protected StructuredStringType availabilityStatus;
    @XmlElement(name = "DataFileQuantity")
    protected BigInteger dataFileQuantity;
    @XmlElement(name = "CollectionCompleteness")
    protected StructuredStringType collectionCompleteness;
    @XmlElement(name = "Item")
    protected List<ItemType> item;
    @XmlElement(name = "Collection")
    protected List<CollectionType> collection;

    /**
     * A citation for the collection. May additionally be rendered in native qualified Dublin Core (dc and dcterms).
     *
     * @return possible object is
     * {@link CitationType }
     */
    public CitationType getCitation() {
        return citation;
    }

    /**
     * Sets the value of the citation property.
     *
     * @param value allowed object is
     *              {@link CitationType }
     */
    public void setCitation(CitationType value) {
        this.citation = value;
    }

    /**
     * Describes the location of the collection within the archive. Repeat for multiple locations such as separate stores for access and archival copies.Gets the value of the locationInArchive property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationInArchive property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationInArchive().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalStringType }
     */
    public List<InternationalStringType> getLocationInArchive() {
        if (locationInArchive == null) {
            locationInArchive = new ArrayList<InternationalStringType>();
        }
        return this.locationInArchive;
    }

    /**
     * The name, code, or number used by the archive to uniquely identify the collection within the archive.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * Sets the value of the callNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCallNumber(String value) {
        this.callNumber = value;
    }

    /**
     * The URL or URN for the collection.
     *
     * @return possible object is
     * {@link String }
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURI(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the itemQuantity property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Sets the value of the itemQuantity property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setItemQuantity(BigInteger value) {
        this.itemQuantity = value;
    }

    /**
     * An archive specific classification for the collection. This may be a topical classification, a classification of intended processing levels, or information on the processing status.
     *
     * @return possible object is
     * {@link StudyClassType }
     */
    public StudyClassType getStudyClass() {
        return studyClass;
    }

    /**
     * Sets the value of the studyClass property.
     *
     * @param value allowed object is
     *              {@link StudyClassType }
     */
    public void setStudyClass(StudyClassType value) {
        this.studyClass = value;
    }

    /**
     * Default access restriction information applying to all of the items in the collection.
     *
     * @return possible object is
     * {@link AccessType }
     */
    public AccessType getDefaultAccess() {
        return defaultAccess;
    }

    /**
     * Sets the value of the defaultAccess property.
     *
     * @param value allowed object is
     *              {@link AccessType }
     */
    public void setDefaultAccess(AccessType value) {
        this.defaultAccess = value;
    }

    /**
     * The original archive for the described collection, expressed as a reference to an organization listed in the organization scheme.Gets the value of the originalArchiveOrganizationReference property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originalArchiveOrganizationReference property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginalArchiveOrganizationReference().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    public List<ReferenceType> getOriginalArchiveOrganizationReference() {
        if (originalArchiveOrganizationReference == null) {
            originalArchiveOrganizationReference = new ArrayList<ReferenceType>();
        }
        return this.originalArchiveOrganizationReference;
    }

    /**
     * A statement of availability for the collection. This is a positive statement (as opposed to access restrictions) which may be used for publication or other purposes. Allows for structured content.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     * Sets the value of the availabilityStatus property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setAvailabilityStatus(StructuredStringType value) {
        this.availabilityStatus = value;
    }

    /**
     * The number of data files in the described collection, expressed as an integer. This is a check sum and should be updated as the contents of the collection changes. The use of this element is best restricted to completed collections where change in the number of objects is not dynamic.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getDataFileQuantity() {
        return dataFileQuantity;
    }

    /**
     * Sets the value of the dataFileQuantity property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setDataFileQuantity(BigInteger value) {
        this.dataFileQuantity = value;
    }

    /**
     * Describes the completeness of the collection. Note coverage gaps as well as collections strengths. This statement may be used for publication or other purposes. Allows for structured content.
     *
     * @return possible object is
     * {@link StructuredStringType }
     */
    public StructuredStringType getCollectionCompleteness() {
        return collectionCompleteness;
    }

    /**
     * Sets the value of the collectionCompleteness property.
     *
     * @param value allowed object is
     *              {@link StructuredStringType }
     */
    public void setCollectionCompleteness(StructuredStringType value) {
        this.collectionCompleteness = value;
    }

    /**
     * Allows for the nesting of Item descriptions with a collection.Gets the value of the item property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     */
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Allows for the nesting of collection descriptions with a collection hierarchical groupings within a collection description.Gets the value of the collection property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collection property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollection().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectionType }
     */
    public List<CollectionType> getCollection() {
        if (collection == null) {
            collection = new ArrayList<CollectionType>();
        }
        return this.collection;
    }

}