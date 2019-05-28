package vu.lt.rest;

import lombok.Getter;
import lombok.Setter;
import vu.lt.persistence.RoomsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/rooms")
public class RoomController {
    @Inject
    @Getter @Setter
    private RoomsDAO roomsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") final Long id) {


        return null;
    }
}
