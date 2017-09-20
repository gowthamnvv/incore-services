//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.physicalinstance;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The value of the statistics and whether it is weighted and/or includes missing values.
 * <p>
 * <p>Java class for StatisticType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="StatisticType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;decimal"&gt;
 *       &lt;attribute name="isWeighted" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="computationBase" type="{ddi:physicalinstance:3_2}ComputationBaseType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatisticType", propOrder = {
        "value"
})
public class StatisticType {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "isWeighted")
    protected Boolean isWeighted;
    @XmlAttribute(name = "computationBase")
    protected ComputationBaseType computationBase;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the isWeighted property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsWeighted() {
        return isWeighted;
    }

    /**
     * Sets the value of the isWeighted property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsWeighted(Boolean value) {
        this.isWeighted = value;
    }

    /**
     * Gets the value of the computationBase property.
     *
     * @return possible object is
     * {@link ComputationBaseType }
     */
    public ComputationBaseType getComputationBase() {
        return computationBase;
    }

    /**
     * Sets the value of the computationBase property.
     *
     * @param value allowed object is
     *              {@link ComputationBaseType }
     */
    public void setComputationBase(ComputationBaseType value) {
        this.computationBase = value;
    }

}