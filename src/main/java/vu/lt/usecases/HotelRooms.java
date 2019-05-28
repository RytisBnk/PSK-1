package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Hotel;
import vu.lt.entities.Room;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.HotelsDAO;
import vu.lt.persistence.RoomsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class HotelRooms {
    @Inject
    private HotelsDAO hotelsDAO;

    @Inject
    private RoomsDAO roomsDAO;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Room roomToCreate = new Room();

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long id = Long.parseLong(requestParams.get("hotelId"));
        hotel = hotelsDAO.findOne(id);
    }

    @Transactional
    @LoggedInvocation
    public String createRoom() {
        roomToCreate.setHotel(hotel);
        roomsDAO.persist(roomToCreate);
        return "rooms?faces-redirect=true&hotelId=" + hotel.getId();
    }
}
