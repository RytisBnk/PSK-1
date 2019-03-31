package vu.lt.persistence;

import lombok.Setter;
import vu.lt.entities.Hotel;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HotelsDAO {
    @PersistenceContext
    @Setter
    private EntityManager entityManager;

    public List<Hotel> loadAll() {
        return entityManager.createNamedQuery("Hotels.findAll", Hotel.class).getResultList();
    }

    public Hotel findOne(long id) {
        return entityManager.find(Hotel.class, id);
    }

    public void persist(Hotel hotel) {
        entityManager.persist(hotel);
    }
}
