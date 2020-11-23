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
 *         &lt;element name="reponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reponse"
})
@XmlRootElement(name = "GetUserResponse")
public class GetUserResponse {

    @XmlElement(required = true)
    protected String reponse;

    /**
     * Obtient la valeur de la propriété reponse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReponse() {
        return reponse;
    }

    /**
     * Définit la valeur de la propriété reponse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReponse(String value) {
        this.reponse = value;
    }

}
