package com.megaByteful.infrastructure.persistence.entity;

import java.util.List;

public interface AppointmentJPAEntity {
    void save(Appointment appointment);

    void update(Appointment appointment);

    void delete(int id);

    Appointment findById(int id);

    List<Appointment> findByCustomerId(int customerId);
}