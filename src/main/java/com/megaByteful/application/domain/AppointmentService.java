package com.megaByteful.application.domain;

import com.megaByteful.application.domain.Appointment;
import com.megaByteful.infrastructure.persistence.entity.AppointmentJPAEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.persistence.EntityNotFoundException;

@Service
public class AppointmentService {
    private final AppointmentJPAEntity appointmentRepository;

    public AppointmentService(AppointmentJPAEntity appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public void scheduleAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Transactional
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.update(appointment);
    }

    @Transactional
    public void cancelAppointment(int id) {

        if (findAppointment(id) == null) {
            throw new EntityNotFoundException("Appointment not found for ID: " + id);
        }
        appointmentRepository.delete(id);
    }

    public Appointment findAppointment(int id) {
        return appointmentRepository.findById(id);
    }
}
