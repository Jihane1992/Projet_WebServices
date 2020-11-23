//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.11.13 à 11:42:28 PM CET 
//


package fr.ensiie.hotels_webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_in" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date_out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id-hotel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id-user" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbr-rooms" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateIn",
    "dateOut",
    "idHotel",
    "idUser",
    "nbrRooms"
})
@XmlRootElement(name = "PostReservationRequest")
public class PostReservationRequest {

    @XmlElement(name = "date_in", required = true, defaultValue = "yyyy-mm-dd")
    protected String dateIn;
    @XmlElement(name = "date_out", required = true, defaultValue = "yyyy-mm-dd")
    protected String dateOut;
    @XmlElement(name = "id-hotel", defaultValue = "0")
    protected int idHotel;
    @XmlElement(name = "id-user", defaultValue = "0")
    protected int idUser;
    @XmlElement(name = "nbr-rooms", defaultValue = "0")
    protected long nbrRooms;

    /**
     * Obtient la valeur de la propriété dateIn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * Définit la valeur de la propriété dateIn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateIn(String value) {
        this.dateIn = value;
    }

    /**
     * Obtient la valeur de la propriété dateOut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * Définit la valeur de la propriété dateOut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOut(String value) {
        this.dateOut = value;
    }

    /**
     * Obtient la valeur de la propriété idHotel.
     * 
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * Définit la valeur de la propriété idHotel.
     * 
     */
    public void setIdHotel(int value) {
        this.idHotel = value;
    }

    /**
     * Obtient la valeur de la propriété idUser.
     * 
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Définit la valeur de la propriété idUser.
     * 
     */
    public void setIdUser(int value) {
        this.idUser = value;
    }

    /**
     * Obtient la valeur de la propriété nbrRooms.
     * 
     */
    public long getNbrRooms() {
        return nbrRooms;
    }

    /**
     * Définit la valeur de la propriété nbrRooms.
     * 
     */
    public void setNbrRooms(long value) {
        this.nbrRooms = value;
    }

}
