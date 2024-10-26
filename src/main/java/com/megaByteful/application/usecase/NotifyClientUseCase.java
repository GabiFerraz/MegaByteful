package com.megaByteful.usecase;

@Scheduled(fixedRate = 3600000) // E99 Mostrar pro time
public class NotifyClientUseCase {
    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;

    public void execute() {
        List<Appointment> appointments = appointmentRepository.findAppointments24HoursBefore();
        for (Appointment appointment : appointments) {
            emailService.send(appointment.getClient().getEmail(), "Heeey você tem um agendamento!");
            appointment.setNotified(true);
            appointmentRepository.save(appointment);
        }
    }
}
