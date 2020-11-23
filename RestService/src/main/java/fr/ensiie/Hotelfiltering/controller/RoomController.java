package fr.ensiie.Hotelfiltering.controller;

import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.Room;
import fr.ensiie.Hotelfiltering.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private HotelService service;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return service.saveHotel(hotel);
    }

    @GetMapping("/rooms")
    public List<Room> findAllRooms(){
        return service.getRooms();
    }

    @GetMapping("/room/{id}")
    public Room findRoomById(@PathVariable int id){
        return service.getRoomById(id);
    }

    @GetMapping("/rooms/one")
    public List<Room> getromsbyhotel(@RequestParam("hotelid") int idhotel){
        return service.getRoomsByHotel(idhotel);
    }
}
