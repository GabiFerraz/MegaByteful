package com.megaByteful.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AppointmentRepositoryImpl implements AppointmentJPAEntity {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Override
    @Transactional
    public void update(Appointment appointment) {
        entityManager.merge(appointment);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Appointment appointment = findById(id);
        if (appointment != null) {
            entityManager.remove(appointment);
        }
    }

    @Override
    public Appointment findById(int id) {
        return entityManager.find(Appointment.class, id);
    }

    @Override
    public List<Appointment> findByCustomerId(int customerId) {
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.customerId = :customerId", Appointment.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }
}
