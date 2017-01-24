//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.05 at 03:37:15 PM CST 
//


package Metadata.Specifications.DDI.CodeBook;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stdyInfoType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="stdyInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{ddi:codebook:2_5}baseElementType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:codebook:2_5}studyBudget" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}abstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}sumDscr" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}qualityStatement" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}notes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:codebook:2_5}exPostEvaluation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stdyInfoType", propOrder = {
        "studyBudgets",
        "subjects",
        "abstracts",
        "sumDscrs",
        "qualityStatement",
        "notes",
        "exPostEvaluations"
})
@XmlRootElement(name = "stdyInfo")
public class StdyInfo
        extends BaseElementType {

    @XmlElement(name = "studyBudget")
    protected List<SimpleTextType> studyBudgets;
    @XmlElement(name = "subject")
    protected List<Subject> subjects;
    @XmlElement(name = "abstract")
    protected List<Abstract> abstracts;
    @XmlElement(name = "sumDscr")
    protected List<SumDscr> sumDscrs;
    protected QualityStatement qualityStatement;
    protected List<Notes> notes;
    @XmlElement(name = "exPostEvaluation")
    protected List<ExPostEvaluation> exPostEvaluations;

    /**
     * Gets the value of the studyBudgets property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studyBudgets property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudyBudgets().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTextType }
     */
    public List<SimpleTextType> getStudyBudgets() {
        if (studyBudgets == null) {
            studyBudgets = new ArrayList<SimpleTextType>();
        }
        return this.studyBudgets;
    }

    /**
     * Gets the value of the subjects property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjects property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjects().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subject }
     */
    public List<Subject> getSubjects() {
        if (subjects == null) {
            subjects = new ArrayList<Subject>();
        }
        return this.subjects;
    }

    /**
     * Gets the value of the abstracts property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstracts property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstracts().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Abstract }
     */
    public List<Abstract> getAbstracts() {
        if (abstracts == null) {
            abstracts = new ArrayList<Abstract>();
        }
        return this.abstracts;
    }

    /**
     * Gets the value of the sumDscrs property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sumDscrs property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSumDscrs().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SumDscr }
     */
    public List<SumDscr> getSumDscrs() {
        if (sumDscrs == null) {
            sumDscrs = new ArrayList<SumDscr>();
        }
        return this.sumDscrs;
    }

    /**
     * Gets the value of the qualityStatement property.
     *
     * @return possible object is
     * {@link QualityStatement }
     */
    public QualityStatement getQualityStatement() {
        return qualityStatement;
    }

    /**
     * Sets the value of the qualityStatement property.
     *
     * @param value allowed object is
     *              {@link QualityStatement }
     */
    public void setQualityStatement(QualityStatement value) {
        this.qualityStatement = value;
    }

    /**
     * Gets the value of the notes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotes().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notes }
     */
    public List<Notes> getNotes() {
        if (notes == null) {
            notes = new ArrayList<Notes>();
        }
        return this.notes;
    }

    /**
     * Gets the value of the exPostEvaluations property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exPostEvaluations property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExPostEvaluations().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExPostEvaluation }
     */
    public List<ExPostEvaluation> getExPostEvaluations() {
        if (exPostEvaluations == null) {
            exPostEvaluations = new ArrayList<ExPostEvaluation>();
        }
        return this.exPostEvaluations;
    }

}
