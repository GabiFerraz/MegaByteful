package com.megaByteful.infrastructure.api;

import com.megaByteful.application.domain.Appointment;
import com.megaByteful.application.domain.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        appointmentService.scheduleAppointment(appointment);
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        appointment.setId(id);
        appointmentService.updateAppointment(appointment);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable int id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findAppointment(@PathVariable int id) {
        Appointment appointment = appointmentService.findAppointment(id);
        return appointment != null ? ResponseEntity.ok(appointment) : ResponseEntity.notFound().build();
    }

}
