//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;xhtml:div xmlns:xhtml="http://www.w3.org/1999/xhtml" xmlns="ddi:codebook:2_5" xmlns:dc="http://purl.org/dc/terms/" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:saxon="http://xml.apache.org/xslt" xmlns:xs="http://www.w3.org/2001/XMLSchema"&gt;&lt;xhtml:h1 class="element_title"&gt;String SystemType&lt;/xhtml:h1&gt;&lt;xhtml:div&gt;&lt;xhtml:h2 class="section_header"&gt;Description&lt;/xhtml:h2&gt;&lt;xhtml:div class="description"&gt;This type restricts the base abstractTextType to only allow for text (i.e. no child elements).&lt;/xhtml:div&gt;&lt;/xhtml:div&gt;&lt;/xhtml:div&gt;
 * </pre>
 * <p>
 * <p>
 * <p>Java class for stringType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="stringType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;ddi:codebook:2_5&gt;abstractTextType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stringType")
@XmlSeeAlso({
        Command.class,
        UnitType.class,
        Custodian.class,
        Participant.class,
        Evaluator.class,
        StandardName.class,
        AuthorizingAgency.class,
        Entry.class
})
public class StringType
        extends AbstractTextType {


}
