package vu.lt.persistence;

import lombok.Setter;
import vu.lt.entities.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RoomsDAO {
    @PersistenceContext
    @Setter
    private EntityManager entityManager;

    public List<Room> loadAll() {
        return entityManager.createNamedQuery("Rooms.findAll", Room.class).getResultList();
    }

    public void persist(Room room) {
        entityManager.persist(room);
    }

    public Room findOne(long id) {
        return entityManager.find(Room.class, id);
    }
}
