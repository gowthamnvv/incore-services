//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.03 at 04:06:24 PM CST 
//


package Metadata.Specifications.DublinCore.terms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DublinCore.elements.SimpleLiteral;


/**
 * This is included as a convenience for schema authors who need to define a root
 * or container element for all of the DC elements and element refinements.
 * <p>
 * <p>Java class for elementOrRefinementContainer complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="elementOrRefinementContainer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;group ref="{http://purl.org/dc/terms/}elementsAndRefinementsGroup"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementOrRefinementContainer", propOrder = {
        "any"
})
public class ElementOrRefinementContainer {

    @XmlElementRef(name = "any", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<SimpleLiteral>> any;

    /**
     * Gets the value of the any property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}
     */
    public List<JAXBElement<SimpleLiteral>> getAny() {
        if (any == null) {
            any = new ArrayList<JAXBElement<SimpleLiteral>>();
        }
        return this.any;
    }

}