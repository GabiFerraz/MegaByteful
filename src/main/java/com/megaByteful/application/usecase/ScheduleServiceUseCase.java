package com.megaByteful.usecase;

import com.megaByteful.domain.Schedule;

public class ScheduleServiceUseCase {
    private final ScheduleServiceRepository scheduleServiceRepository;

    public ScheduleServiceUseCase(ScheduleService scheduleServiceRepository) {
        this.scheduleServiceRepository = scheduleServiceRepository;
    }

    public Schedule execute(Schedule schedule) {
        // Lógica para verificar disponibilidade de horário
        return scheduleServiceRepository.save(schedule);
    }
}
