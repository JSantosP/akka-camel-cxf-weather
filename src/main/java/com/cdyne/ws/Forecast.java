
package com.cdyne.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Forecast complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Forecast">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="WeatherID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Desciption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Temperatures" type="{http://ws.cdyne.com/WeatherWS/}temp"/>
 *         &lt;element name="ProbabilityOfPrecipiation" type="{http://ws.cdyne.com/WeatherWS/}POP"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Forecast", propOrder = {
    "date",
    "weatherID",
    "desciption",
    "temperatures",
    "probabilityOfPrecipiation"
})
public class Forecast {

    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "WeatherID")
    protected short weatherID;
    @XmlElement(name = "Desciption")
    protected String desciption;
    @XmlElement(name = "Temperatures", required = true)
    protected Temp temperatures;
    @XmlElement(name = "ProbabilityOfPrecipiation", required = true)
    protected POP probabilityOfPrecipiation;

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad weatherID.
     * 
     */
    public short getWeatherID() {
        return weatherID;
    }

    /**
     * Define el valor de la propiedad weatherID.
     * 
     */
    public void setWeatherID(short value) {
        this.weatherID = value;
    }

    /**
     * Obtiene el valor de la propiedad desciption.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * Define el valor de la propiedad desciption.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesciption(String value) {
        this.desciption = value;
    }

    /**
     * Obtiene el valor de la propiedad temperatures.
     * 
     * @return
     *     possible object is
     *     {@link Temp }
     *     
     */
    public Temp getTemperatures() {
        return temperatures;
    }

    /**
     * Define el valor de la propiedad temperatures.
     * 
     * @param value
     *     allowed object is
     *     {@link Temp }
     *     
     */
    public void setTemperatures(Temp value) {
        this.temperatures = value;
    }

    /**
     * Obtiene el valor de la propiedad probabilityOfPrecipiation.
     * 
     * @return
     *     possible object is
     *     {@link POP }
     *     
     */
    public POP getProbabilityOfPrecipiation() {
        return probabilityOfPrecipiation;
    }

    /**
     * Define el valor de la propiedad probabilityOfPrecipiation.
     * 
     * @param value
     *     allowed object is
     *     {@link POP }
     *     
     */
    public void setProbabilityOfPrecipiation(POP value) {
        this.probabilityOfPrecipiation = value;
    }

}
