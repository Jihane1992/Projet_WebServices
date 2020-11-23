package fr.ensiie.hotels_webservices.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ensiie.hotels_webservices.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HotelService {

    OkHttpClient client = new OkHttpClient(); // instance of okhppp

    /**
     * get hotels from rest service
     *
     * @param request
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public GetHotelResponse gethotels(GetHotelRequest request) throws IOException, IllegalAccessException, InstantiationException {
        GetHotelResponse getHotelResponse = new GetHotelResponse();
        String url = "http://localhost:9191/hotels/filter" + "?datein=" + request.getDateIn() + "&dateout=" + request.getDateOut() + "&nbrroom=" + request.getNbrRooms();
        Request requestHotels = new Request.Builder().url(url).build();
        Response response = client.newCall(requestHotels).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Hotel> hotels = objectMapper.readValue(response.body().string(), new TypeReference<List<Hotel>>() {
        });
        List<Hotel> hotelList = getHotelResponse.getHotel();
        Hotel hotel1 = new Hotel();
        hotel1.setId(0);
        hotel1.setName("hotel not found");
        hotel1.setDescription("");
        if (hotels.isEmpty()) {
            hotelList.add(hotel1);
        } else {
            hotelList.addAll(hotels);
        }
        return getHotelResponse;
    }
    /**
     * This function allows to get the user's reservations from the api rest
     * @param request
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public GetMyReservationResponse getmyreservationsresponse(GetMyReservationRequest request) throws IOException, IllegalAccessException, InstantiationException {
        GetMyReservationResponse getMyReservationsResponse = new GetMyReservationResponse();
        String url = "http://localhost:9191/bookingall" + "?userid=" + request.getIdUser();
        Request requestreservation = new Request.Builder().url(url).build();
        Response response1 = client.newCall(requestreservation).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Reservation> reservations = objectMapper.readValue(response1.body().string(), new TypeReference<List<Reservation>>() {
        });
        List<Reservation> reservationList = getMyReservationsResponse.getReservation();
        //Reservation reservation1 = new Reservation();
        //reservation1.setId(0);

        reservationList.addAll(reservations);

        return getMyReservationsResponse;
    }
    /**
     * This function allows to make a reservation via rest service
     *
     * @param request1
     * @return
     * @throws IOException
     */
    public PostReservationResponse getreservation(PostReservationRequest request1) throws IOException {
        String success = "Reservation successful";
        String echec = "Echec reservation";
        PostReservationResponse getReservationResponse = new PostReservationResponse();
        String url = "http://localhost:9191/savebookinghotel?" + "datein=" + request1.getDateIn() + "&dateout=" + request1.getDateOut() + "&idhotel=" + request1.getIdHotel() + "&iduser=" + request1.getIdUser() + "&nbroom=" + request1.getNbrRooms();
        Request requestHotels = new Request.Builder().url(url).build();
        Response response = client.newCall(requestHotels).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        Integer bdy = objectMapper.readValue(response.body().string(), new TypeReference<Integer>() {
        });
        if (bdy == 1) {
            getReservationResponse.setReponse(success);
        } else {
            getReservationResponse.setReponse(echec);
        }
        return getReservationResponse;
    }

    /**
     * This function allows to cancel a reservation
     * @param request2
     * @return
     * @throws IOException
     */
    public CancelReservationResponse cancelreservation(CancelReservationRequest request2) throws IOException {
        String success1 = "Your reservation has been cancelled.";
        String echec1 = "Echec reservation's cancellation";
        CancelReservationResponse cancelReservationResponse = new CancelReservationResponse();
        String url = "http://localhost:9191/deletebookinghotel?" + "idreservation=" + request2.getNoReservation();
        Request requestHotels = new Request.Builder().url(url).build();
        Response response = client.newCall(requestHotels).execute();
        if (response.isSuccessful()) {
            cancelReservationResponse.setReponse(success1);
        } else {
            cancelReservationResponse.setReponse(echec1);
        }
        return cancelReservationResponse;
    }
    /**
     * This function allows to get the response if a user exist or not via the the rest api
     * @param request3
     * @return
     * @throws IOException
     */
    public GetUserResponse getuserresponse(GetUserRequest request3) throws IOException {
        String success1 = "cnx";
        String echec1 = "echec";
        GetUserResponse getUserResponse = new GetUserResponse();
        String url = "http://localhost:9191/userget?" + "usrname=" + request3.getUsername() + "&usrpassword=" + request3.getUserpassword();
        Request requestHotels = new Request.Builder().url(url).build();
        Response response = client.newCall(requestHotels).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        Integer body = objectMapper.readValue(response.body().string(), new TypeReference<Integer>() {
        });
        if (body == 0) {
            getUserResponse.setReponse(echec1);
        } else {
            getUserResponse.setReponse(success1);
        }
        return getUserResponse;
    }
}