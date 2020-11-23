package fr.ensiie.Hotelfiltering.repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;

import fr.ensiie.Hotelfiltering.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer>{
    Hotel findByName(String name);

    @Query("select h from Hotel h where (select count (r) from Room r where h.id = r.hotel.id and r.id not in (select b.room.id from Booking b where cast(:DATE_IN as timestamp) between b.date_in and b.date_out or cast(:DATE_OUT as timestamp) between b.date_in and b.date_out)) >= :NBR_ROOM")
    List<Hotel> gethotelavailable(@Param("DATE_IN") @DateTimeFormat String date_in, @Param("DATE_OUT") @DateTimeFormat String date_out, @Param("NBR_ROOM") long nbr);
}