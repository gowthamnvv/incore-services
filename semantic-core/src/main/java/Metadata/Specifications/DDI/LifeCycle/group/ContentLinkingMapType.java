//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.group;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains a stack of links from the LocalAddedContent to the Depository content and provides instructions regarding the relationship between the local added content and the deposited content.
 * <p>
 * <p>Java class for ContentLinkingMapType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ContentLinkingMapType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:group:3_2}LinkingMap" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentLinkingMapType", propOrder = {
        "linkingMap"
})
public class ContentLinkingMapType {

    @XmlElement(name = "LinkingMap")
    protected List<LinkingMapType> linkingMap;

    /**
     * Provides a link from a local object to a deposited object via reference and designates if the added material should Override, act as AddedContent, or DeleteContent in the original deposited material.Gets the value of the linkingMap property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkingMap property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkingMap().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkingMapType }
     */
    public List<LinkingMapType> getLinkingMap() {
        if (linkingMap == null) {
            linkingMap = new ArrayList<LinkingMapType>();
        }
        return this.linkingMap;
    }

}
