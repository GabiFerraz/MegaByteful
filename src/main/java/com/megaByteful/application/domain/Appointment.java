package com.megaByteful.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
public class Appointment {
    private int id;
    private int scheduleId;
    private int customerId;

    @NoArgsConstructor
    public Appointment() {}

    @AllArgsConstructor
    public Appointment(int id, int scheduleId, int customerId) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.customerId = customerId;
    }

}
