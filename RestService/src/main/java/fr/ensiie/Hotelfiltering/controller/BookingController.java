package fr.ensiie.Hotelfiltering.controller;

import fr.ensiie.Hotelfiltering.entity.Booking;
import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.Room;
import fr.ensiie.Hotelfiltering.service.HotelService;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private HotelService service;

    @GetMapping("/allbooking")
    @ResponseBody
    public Iterable<Booking> findAllBooking(){
        return service.getBooking();
    }

    @PostMapping(value="/addbooking/"/*produces = MediaType.APPLICATION_JSON_VALUE*/)
    @ResponseBody
    public Booking addbooking(@RequestBody Booking booking ){
        booking.setRoom(booking.getRoom());
        booking.setUser(booking.getUser());
        return service.savebooking(booking);
    }
    /**
     * Add booking with get and idroom
     * @param datein
     * @param dateout
     * @param idroom
     * @param iduser
     */
    @GetMapping("addbookingget")
    @ResponseBody
    public Booking addbookingget(@RequestParam("datein") String datein,@RequestParam("dateout") String dateout,@RequestParam("idroom") int idroom, @RequestParam("iduser") int iduser) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Booking booking = new Booking();
            booking.setUser(service.getUserById(iduser));
            booking.setRoom(service.getRoomById(idroom));
            booking.setDate_in(dateFormat.parse(datein));
            booking.setDate_out(dateFormat.parse(dateout));
            return service.savebooking(booking);
    }

    /**
     * save multiple booking with idhotel
     * @param datein
     * @param dateout
     * @param idhotel
     * @param iduser
     * @param nbroom
     * @throws ParseException
     */
    @GetMapping("savebookinghotel")
    @ResponseBody
    public int savebookinghotel(@RequestParam("datein") String datein,@RequestParam("dateout") String dateout,@RequestParam("idhotel") int idhotel, @RequestParam("iduser") int iduser, int nbroom) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Room> roomshotel = service.getRoomsAvailablesByHotelId(datein,dateout,idhotel);
        List<Integer> intList = new ArrayList<Integer>();

        Date date = new Date();   //Current Date
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date today = dateFormat.parse(modifiedDate);
        Date datein1 = dateFormat.parse(datein);
        Date dateout1 = dateFormat.parse(dateout);
        if (datein1.before(dateout1) && (datein1.after(today) || datein1.equals(today))){
            for (int i = 0; i < nbroom; i++) {
                for (Room room : roomshotel) {
                    intList.add(room.getId());
                }
            }
            for (int i = 0; i < nbroom; i++) {
                Booking booking = new Booking();
                booking.setUser(service.getUserById(iduser));
                booking.setRoom(service.getRoomById(intList.get(i)));
                booking.setDate_in(datein1);
                booking.setDate_out(dateout1);
                service.savebooking(booking);
            }
          return 1;
        }
        else {
           return 0;
        }
    }

    @DeleteMapping("deletebookinghotel")
    @ResponseBody
    public void deletebookinghotel(@RequestParam("idreservation") long idreseration) throws ParseException {
                service.deletBookingById(idreseration);
    }

    @GetMapping("/bookingall")
    public List<Booking> getbookingbyuser(@RequestParam("userid") int iduser){
        return service.getBookingByUser(iduser);
    }
    @GetMapping("/bookingobject")
    public List<Object> getsomebookingbyuser(@RequestParam("userid") int iduser){
        return service.getsomeBookingByUser(iduser);
    }

}
