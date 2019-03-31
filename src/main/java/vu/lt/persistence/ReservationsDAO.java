package vu.lt.persistence;

import lombok.Setter;
import vu.lt.entities.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReservationsDAO {
    @PersistenceContext
    @Setter
    private EntityManager entityManager;

    public List<Reservation> loadAll() {
        return entityManager.createNamedQuery("Reservations.findAll", Reservation.class).getResultList();
    }

    public Reservation findOne(long id) {
        return entityManager.find(Reservation.class, id);
    }

    public void persist(Reservation reservation) {
        entityManager.persist(reservation);
    }
}
