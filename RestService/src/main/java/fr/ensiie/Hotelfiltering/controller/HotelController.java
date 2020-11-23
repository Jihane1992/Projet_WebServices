package fr.ensiie.Hotelfiltering.controller;

import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.Room;
import fr.ensiie.Hotelfiltering.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService service;
/**
    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return service.saveHotel(hotel);
    }*/

    @GetMapping("/hotels")
    public List<Hotel> findAllHotels(){
        return service.getHotels();
    }

    @GetMapping("/hotel/{id}")
    public Hotel findHotelById(@PathVariable int id){
        return service.getHotelById(id);
    }

    @GetMapping("/hotels/filter")
    public List<Hotel> gethotelsfilter(@RequestParam("datein") String datein, @RequestParam("dateout") String dateout,@RequestParam("nbrroom") long nbrroom) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Hotel> listhotels=new ArrayList<>();
        Date date = new Date();   //Current Date
        String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date today = dateFormat.parse(modifiedDate);
        Date datein1 = dateFormat.parse(datein);
        Date dateout1 = dateFormat.parse(dateout);
        if (datein1.before(dateout1) && (datein1.after(today) || datein1.equals(today))) {
            listhotels= service.gethotelavailable(datein, dateout, nbrroom);
        }
        return listhotels;
    }
}
