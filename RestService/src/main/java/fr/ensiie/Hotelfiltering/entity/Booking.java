package fr.ensiie.Hotelfiltering.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "booked_rooms", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_room", "date_in", "date_out"})})
public class  Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_bookin")
    private long idBooking;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_room")
    private Room room;

    //@Temporal(TemporalType.DATE)
    @Column(name = "date_in")
    private Date date_in;

    //@Temporal(TemporalType.DATE)
    @Column(name = "date_out")
    private Date date_out;
}
