package vu.lt.rest.controllers;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Hotel;
import vu.lt.entities.Room;
import vu.lt.persistence.HotelsDAO;
import vu.lt.persistence.RoomsDAO;
import vu.lt.rest.contracts.NewRoomJson;
import vu.lt.rest.contracts.RoomJson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/rooms")
public class RoomController {
    @Inject
    @Getter @Setter
    private RoomsDAO roomsDAO;

    @Inject
    @Getter @Setter
    private HotelsDAO hotelsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") final Long id) {
        Room room = roomsDAO.findOne(id);
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        RoomJson data = new RoomJson(room.getId(), room.getHotel().getName(), room.getNumber());
        return Response.ok(data).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long id, RoomJson data) {
        try {
            Room room = roomsDAO.findOne(id);
            if (room == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            room.setNumber(data.getNumber());
            roomsDAO.update(room);
            return Response.ok().build();
        }
        catch (OptimisticLockException exc) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createRoom(NewRoomJson newRoom) {
        Hotel hotel = hotelsDAO.findOne(newRoom.getHotelId());
        if (hotel == null) {
            System.out.println("NOT FOUND NX??");
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Room room = new Room();
        room.setNumber(newRoom.getNumber());
        room.setHotel(hotel);
        roomsDAO.persist(room);

        return Response.ok(new RoomJson(room.getId(), room.getHotel().getName(), room.getNumber())).build();
    }
}
