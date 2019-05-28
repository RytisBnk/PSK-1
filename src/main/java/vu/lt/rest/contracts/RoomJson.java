package vu.lt.rest.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RoomJson {
    private long id;
    private String hotelName;
    private int number;
}
