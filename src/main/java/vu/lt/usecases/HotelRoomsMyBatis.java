package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.HotelMapper;
import vu.lt.mybatis.dao.RoomMapper;
import vu.lt.mybatis.model.Hotel;
import vu.lt.mybatis.model.Room;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class HotelRoomsMyBatis {
    @Inject
    private RoomMapper roomMapper;

    @Inject
    private HotelMapper hotelMapper;

    @Getter @Setter
    private Room roomToCreate = new Room();

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private List<Room> hotelRooms = new ArrayList<>();


    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long hotelId = Long.parseLong(requestParams.get("hotelId"));
        hotel = hotelMapper.selectByPrimaryKey(hotelId);
        hotelRooms = roomMapper.selectRoomsForHotel(hotelId);
    }

    @Transactional
    public String createRoom() {
        roomToCreate.setHotelId(hotel.getId());
        roomMapper.insert(roomToCreate);
        return "/myBatis/rooms?faces-redirect=true&hotelId=" + hotel.getId();
    }
}
