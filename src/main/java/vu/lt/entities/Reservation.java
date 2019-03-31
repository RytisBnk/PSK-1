package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "Reservations.findAll", query = "select r from Reservation as r")
})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;
    private Date endDate;
    @ManyToMany
    private List<Room> reservedRooms;
}
