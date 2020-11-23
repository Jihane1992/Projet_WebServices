//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.11.13 à 11:42:28 PM CET 
//


package fr.ensiie.hotels_webservices.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.ensiie.hotels_webservices.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.ensiie.hotels_webservices.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CancelReservationRequest }
     * 
     */
    public CancelReservationRequest createCancelReservationRequest() {
        return new CancelReservationRequest();
    }

    /**
     * Create an instance of {@link CancelReservationResponse }
     * 
     */
    public CancelReservationResponse createCancelReservationResponse() {
        return new CancelReservationResponse();
    }

    /**
     * Create an instance of {@link GetUserRequest }
     * 
     */
    public GetUserRequest createGetUserRequest() {
        return new GetUserRequest();
    }

    /**
     * Create an instance of {@link GetMyReservationResponse }
     * 
     */
    public GetMyReservationResponse createGetMyReservationResponse() {
        return new GetMyReservationResponse();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetHotelRequest }
     * 
     */
    public GetHotelRequest createGetHotelRequest() {
        return new GetHotelRequest();
    }

    /**
     * Create an instance of {@link GetMyReservationRequest }
     * 
     */
    public GetMyReservationRequest createGetMyReservationRequest() {
        return new GetMyReservationRequest();
    }

    /**
     * Create an instance of {@link PostReservationResponse }
     * 
     */
    public PostReservationResponse createPostReservationResponse() {
        return new PostReservationResponse();
    }

    /**
     * Create an instance of {@link PostReservationRequest }
     * 
     */
    public PostReservationRequest createPostReservationRequest() {
        return new PostReservationRequest();
    }

    /**
     * Create an instance of {@link GetHotelResponse }
     * 
     */
    public GetHotelResponse createGetHotelResponse() {
        return new GetHotelResponse();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

}
