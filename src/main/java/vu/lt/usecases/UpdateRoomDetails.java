package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Room;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.RoomsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateRoomDetails implements Serializable {
    private Room room;

    @Inject
    private RoomsDAO roomsDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(requestParams.get("roomId"));
        this.room = roomsDAO.findOne(id);
    }

    @Transactional
    @LoggedInvocation
    public String updateRoom() {
        try {
            roomsDAO.update(room);
        }
        catch (OptimisticLockException exc) {
            return "/roomDetails.xhtml?faces-redirect=true&roomId=" + this.room.getId() + "&error=optimistic-lock-exception";
        }
        return "rooms.xhtml?hotelId=" + this.room.getHotel().getId() + "&faces-redirect=true";
    }
}
