//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Allows for a specific machine actionable description of the restriction process using a ProcessingInstructionReference, if one currently exists, or through a CommandCode. In the case of a physical instance, the RestrictionProcess would be the same as a case, record or variable selection process.
 * <p>
 * <p>Java class for RestrictionProcessType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RestrictionProcessType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ProcessingInstructionReference"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}CommandCode"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictionProcessType", propOrder = {
        "processingInstructionReference",
        "commandCode"
})
public class RestrictionProcessType {

    @XmlElement(name = "ProcessingInstructionReference")
    protected ProcessingInstructionReferenceType processingInstructionReference;
    @XmlElement(name = "CommandCode")
    protected CommandCodeType commandCode;

    /**
     * Reference to a ProcessingInstruction containing the process instructions for restricting a level of coverage.
     *
     * @return possible object is
     * {@link ProcessingInstructionReferenceType }
     */
    public ProcessingInstructionReferenceType getProcessingInstructionReference() {
        return processingInstructionReference;
    }

    /**
     * Sets the value of the processingInstructionReference property.
     *
     * @param value allowed object is
     *              {@link ProcessingInstructionReferenceType }
     */
    public void setProcessingInstructionReference(ProcessingInstructionReferenceType value) {
        this.processingInstructionReference = value;
    }

    /**
     * The process instructions for restricting a level of coverage expressed as a command code.
     *
     * @return possible object is
     * {@link CommandCodeType }
     */
    public CommandCodeType getCommandCode() {
        return commandCode;
    }

    /**
     * Sets the value of the commandCode property.
     *
     * @param value allowed object is
     *              {@link CommandCodeType }
     */
    public void setCommandCode(CommandCodeType value) {
        this.commandCode = value;
    }

}
