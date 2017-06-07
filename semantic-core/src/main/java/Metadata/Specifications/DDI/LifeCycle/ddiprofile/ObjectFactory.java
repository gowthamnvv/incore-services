//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.ddiprofile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import Metadata.Specifications.DDI.LifeCycle.reusable.CodeValueType;
import Metadata.Specifications.DDI.LifeCycle.reusable.InternationalStringType;
import Metadata.Specifications.DDI.LifeCycle.reusable.NameType;
import Metadata.Specifications.DDI.LifeCycle.reusable.StructuredStringType;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the ddi.ddiprofile package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DDIProfile_QNAME = new QName("ddi:ddiprofile:3_2", "DDIProfile");
    private final static QName _DDIProfileName_QNAME = new QName("ddi:ddiprofile:3_2", "DDIProfileName");
    private final static QName _XMLPrefixMap_QNAME = new QName("ddi:ddiprofile:3_2", "XMLPrefixMap");
    private final static QName _Instructions_QNAME = new QName("ddi:ddiprofile:3_2", "Instructions");
    private final static QName _AlternateName_QNAME = new QName("ddi:ddiprofile:3_2", "AlternateName");
    private final static QName _ApplicationOfProfile_QNAME = new QName("ddi:ddiprofile:3_2", "ApplicationOfProfile");
    private final static QName _Used_QNAME = new QName("ddi:ddiprofile:3_2", "Used");
    private final static QName _NotUsed_QNAME = new QName("ddi:ddiprofile:3_2", "NotUsed");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ddi.ddiprofile
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DDIProfileType }
     */
    public DDIProfileType createDDIProfileType() {
        return new DDIProfileType();
    }

    /**
     * Create an instance of {@link XMLPrefixMapType }
     */
    public XMLPrefixMapType createXMLPrefixMapType() {
        return new XMLPrefixMapType();
    }

    /**
     * Create an instance of {@link UsedType }
     */
    public UsedType createUsedType() {
        return new UsedType();
    }

    /**
     * Create an instance of {@link NotUsedType }
     */
    public NotUsedType createNotUsedType() {
        return new NotUsedType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DDIProfileType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "DDIProfile")
    public JAXBElement<DDIProfileType> createDDIProfile(DDIProfileType value) {
        return new JAXBElement<DDIProfileType>(_DDIProfile_QNAME, DDIProfileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "DDIProfileName")
    public JAXBElement<NameType> createDDIProfileName(NameType value) {
        return new JAXBElement<NameType>(_DDIProfileName_QNAME, NameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLPrefixMapType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "XMLPrefixMap")
    public JAXBElement<XMLPrefixMapType> createXMLPrefixMap(XMLPrefixMapType value) {
        return new JAXBElement<XMLPrefixMapType>(_XMLPrefixMap_QNAME, XMLPrefixMapType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuredStringType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "Instructions")
    public JAXBElement<StructuredStringType> createInstructions(StructuredStringType value) {
        return new JAXBElement<StructuredStringType>(_Instructions_QNAME, StructuredStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternationalStringType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "AlternateName")
    public JAXBElement<InternationalStringType> createAlternateName(InternationalStringType value) {
        return new JAXBElement<InternationalStringType>(_AlternateName_QNAME, InternationalStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeValueType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "ApplicationOfProfile")
    public JAXBElement<CodeValueType> createApplicationOfProfile(CodeValueType value) {
        return new JAXBElement<CodeValueType>(_ApplicationOfProfile_QNAME, CodeValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsedType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "Used")
    public JAXBElement<UsedType> createUsed(UsedType value) {
        return new JAXBElement<UsedType>(_Used_QNAME, UsedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotUsedType }{@code >}}
     */
    @XmlElementDecl(namespace = "ddi:ddiprofile:3_2", name = "NotUsed")
    public JAXBElement<NotUsedType> createNotUsed(NotUsedType value) {
        return new JAXBElement<NotUsedType>(_NotUsed_QNAME, NotUsedType.class, null, value);
    }

}