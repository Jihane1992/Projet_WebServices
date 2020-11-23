package fr.ensiie.Hotelfiltering.repository;

import fr.ensiie.Hotelfiltering.entity.Booking;
import fr.ensiie.Hotelfiltering.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b.user.id=:userid ")
     List<Booking> getBookingByUser(@Param("userid") int id);

    @Query("select b.idBooking,b.date_out,b.date_out,b.room.description,b.room.hotel.name from Booking b where b.user.id=:userid ")
    List<Object> getsomeBookingByUser(@Param("userid") int id);

}
