//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.datacollection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import Metadata.Specifications.DDI.LifeCycle.reusable.BindingType;
import Metadata.Specifications.DDI.LifeCycle.reusable.ReferenceType;


/**
 * A reference to a control construct of any type with the ability to bind the InParameter or OutParameter of the ControlConstruct to external information as needed.ComputationItem, IfThenElse, Loop, QuestionConstruct, RepeatUntil, RepeatWhile, Sequence, or StatementItem
 * <p>
 * <p>Java class for ControlConstructReferenceType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ControlConstructReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:reusable:3_2}ReferenceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Binding" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlConstructReferenceType", propOrder = {
        "binding"
})
public class ControlConstructReferenceType
        extends ReferenceType {

    @XmlElement(name = "Binding", namespace = "ddi:reusable:3_2")
    protected List<BindingType> binding;

    /**
     * A structure used to bind the content of a parameter declared as the source to a parameter declared as the target. For example, binding the output of a question to the input of a generation instruction. Question A has an OutParameter X. Generation Instruction has an InParameter Y used in the recode instruction. Binding defines the content of InParameter Y to be whatever is provided by OutParameter X for use in the calculation of the recode.Gets the value of the binding property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the binding property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBinding().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BindingType }
     */
    public List<BindingType> getBinding() {
        if (binding == null) {
            binding = new ArrayList<BindingType>();
        }
        return this.binding;
    }

}