package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "ROOM")
@NamedQueries({
        @NamedQuery(name = "Rooms.findAll", query = "select r from Room as r")
})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;
    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;
    @ManyToMany(mappedBy = "reservedRooms")
    private List<Reservation> reservations;
}
