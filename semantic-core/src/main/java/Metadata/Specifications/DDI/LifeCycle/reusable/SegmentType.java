//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.04 at 03:10:13 PM CST 
//


package Metadata.Specifications.DDI.LifeCycle.reusable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A structure used to express explicit segments or regions within different types of external materials (Textual, Audio, Video, XML, and Image). Provides the appropriate start, stop, or region definitions for each type.
 * <p>
 * <p>Java class for SegmentType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="SegmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Textual" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Audio" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}Video" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="XML" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{ddi:reusable:3_2}ImageArea" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SegmentType", propOrder = {
        "textual",
        "audio",
        "video",
        "xml",
        "imageArea"
})
public class SegmentType {

    @XmlElement(name = "Textual")
    protected List<TextualType> textual;
    @XmlElement(name = "Audio")
    protected List<AudioType> audio;
    @XmlElement(name = "Video")
    protected List<VideoType> video;
    @XmlElement(name = "XML")
    protected List<String> xml;
    @XmlElement(name = "ImageArea")
    protected List<ImageAreaType> imageArea;

    /**
     * Defines the segment of textual content used by the parent object. Can identify a set of lines and or characters used to define the segment.Gets the value of the textual property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textual property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextual().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextualType }
     */
    public List<TextualType> getTextual() {
        if (textual == null) {
            textual = new ArrayList<TextualType>();
        }
        return this.textual;
    }

    /**
     * Describes the type and length of the audio segment.Gets the value of the audio property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audio property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudio().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AudioType }
     */
    public List<AudioType> getAudio() {
        if (audio == null) {
            audio = new ArrayList<AudioType>();
        }
        return this.audio;
    }

    /**
     * Describes the type and length of the video segment.Gets the value of the video property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the video property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideo().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VideoType }
     */
    public List<VideoType> getVideo() {
        if (video == null) {
            video = new ArrayList<VideoType>();
        }
        return this.video;
    }

    /**
     * Gets the value of the xml property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xml property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXML().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getXML() {
        if (xml == null) {
            xml = new ArrayList<String>();
        }
        return this.xml;
    }

    /**
     * Defines the shape and area of an image used as part of a location representation. The shape is defined as a Rectangle, Circle, or Polygon and Coordinates provides the information required to define it.Gets the value of the imageArea property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageArea property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageArea().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageAreaType }
     */
    public List<ImageAreaType> getImageArea() {
        if (imageArea == null) {
            imageArea = new ArrayList<ImageAreaType>();
        }
        return this.imageArea;
    }

}
