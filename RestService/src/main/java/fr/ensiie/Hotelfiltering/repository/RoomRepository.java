package fr.ensiie.Hotelfiltering.repository;

import fr.ensiie.Hotelfiltering.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query("select r from Room r where r.hotel.id= ?1")
    List<Room> getRoomsByHotel(@Param("hotelid") int id);

    @Query("select r from Room r where r.hotel.id= :ID_HOTEL and r.id not in (select b.room.id from Booking b where cast(:DATE_IN as timestamp) between b.date_in and b.date_out or cast(:DATE_OUT as timestamp) between b.date_in and b.date_out)")
    List<Room> getRoomsAvailablesByHotel(@Param("DATE_IN") @DateTimeFormat String date_in, @Param("DATE_OUT") @DateTimeFormat String date_out,@Param("ID_HOTEL")int idhotel);
}
