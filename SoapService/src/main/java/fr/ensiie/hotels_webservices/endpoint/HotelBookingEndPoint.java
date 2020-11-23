package fr.ensiie.hotels_webservices.endpoint;

import fr.ensiie.hotels_webservices.model.*;
import fr.ensiie.hotels_webservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;

@Endpoint
public class HotelBookingEndPoint {
    private static final String NAMESPACE = "http://www.ensiie.fr/hotels_webservices/model";
    @Autowired
    private HotelService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetHotelRequest")
    @ResponsePayload
    public GetHotelResponse getHotelStatus(@RequestPayload GetHotelRequest request) throws IllegalAccessException, IOException, InstantiationException {
        return service.gethotels(request);
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "PostReservationRequest")
    @ResponsePayload
    public PostReservationResponse getReservationstatus(@RequestPayload PostReservationRequest request1) throws IOException {
        return service.getreservation(request1);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CancelReservationRequest")
    @ResponsePayload
    public CancelReservationResponse cancelreservationstatus(@RequestPayload CancelReservationRequest request2) throws IOException {
        return service.cancelreservation(request2);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetUserRequest")
    @ResponsePayload
    public GetUserResponse getuserresponse(@RequestPayload GetUserRequest request3) throws IOException {
        return service.getuserresponse(request3);
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetMyReservationRequest")
    @ResponsePayload
    public GetMyReservationResponse getmyreservationresponse(@RequestPayload GetMyReservationRequest request4) throws IOException, InstantiationException, IllegalAccessException {
        return service.getmyreservationsresponse(request4);
    }

}
