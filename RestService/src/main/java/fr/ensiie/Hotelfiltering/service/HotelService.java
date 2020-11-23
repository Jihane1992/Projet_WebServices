package fr.ensiie.Hotelfiltering.service;

import fr.ensiie.Hotelfiltering.entity.Booking;
import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.Room;
import fr.ensiie.Hotelfiltering.entity.User;
import fr.ensiie.Hotelfiltering.repository.BookingRepository;
import fr.ensiie.Hotelfiltering.repository.HotelRepository;
import fr.ensiie.Hotelfiltering.repository.RoomRepository;
import fr.ensiie.Hotelfiltering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestBody;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    DataSource dataSource;

    @Autowired
    private HotelRepository repository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PersistenceContext
    private EntityManager entityManager;
    public Hotel saveHotel(Hotel hotel){
       return  repository.save(hotel);
    }

    /**
     * Savebooking
     * @param booking
     * @return
     */
    public Booking savebooking(Booking booking){
        return bookingRepository.save(booking);
    }

    /**
     * Get the hotels list
     * @return
     */
    public List<Hotel> getHotels(){
        return repository.findAll();
    }

    /**
     * Get the rooms list
     * @return
     */
    public List<Room> getRooms() { return roomRepository.findAll();}

    /**
     * Get an hotel by id
     * @param id
     * @return
     */
    public Hotel getHotelById(int id){
        return repository.findById(id).orElse(null);
    }

    /**
     * get room by id
     * @param id
     * @return
     */
    public Room getRoomById(int id){
        return roomRepository.findById(id).orElse(null);
    }

    /**
     * get users list
     * @return
     */
    public List<User> getUsers(){return userRepository.findAll();}

    /**
     * save a user
     * @param user
     * @return
     */
    public User saveUser(User user){ return userRepository.save(user);}

    /**
     * get the booking list
     * @return
     */
    public Iterable<Booking> getBooking(){return bookingRepository.findAll();}

    /**
     * get the list of availables hotels on period of time
     * @param datein
     * @param dateout
     * @param nbr
     * @return
     */
    public List<Hotel> gethotelavailable(String datein, String dateout, long nbr) {
        return repository.gethotelavailable(datein,dateout,nbr);
    }

    /**
     * get room bu hotelid
     * @param id
     * @return
     */
    public List<Room> getRoomsByHotel(int id){
        return roomRepository.getRoomsByHotel(id);
    }
    public List<Booking> getBookingByUser(int id){
        return bookingRepository.getBookingByUser(id);
    }
    public List<Object> getsomeBookingByUser(int id){
        return bookingRepository.getsomeBookingByUser(id);
    }

    /**
     * Get la liste des hotels disponible dans un hotels
     * @param idhotel
     * @return
     */
    public List<Room> getRoomsAvailablesByHotelId(String datein, String dateout, int idhotel){
        return roomRepository.getRoomsAvailablesByHotel(datein,dateout,idhotel);
    }

    /**
     * get a hotel by name
     * @param name
     * @return
     */
    public Hotel getHotelByName(String name){
        return repository.findByName(name);
    }

    /**
     * delete a hotel
     * @param id
     * @return
     */
    public String deletHotel(int id){
        repository.deleteById(id);
        return "Hotel removed !!"+id;
    }

    /**
     * delete a reservation by id
     * @param id
     */
    public void deletBookingById(long id){
        bookingRepository.deleteById(id);
    }
    public List<Booking> displayBookingOfUser(int iduser){
        return bookingRepository.getBookingByUser(iduser);
    }

    /**
     * getUserById
     * @return User
     */
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User loginget(String username, String userpassword){return userRepository.findByUserNAmeAndPassword(username,userpassword);}

}
