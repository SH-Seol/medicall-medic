package com.medicall.domain.doctor;

import com.medicall.domain.address.Address;
import java.time.LocalDateTime;

public record Appointment(
        String patientName,
        Address address,
        String symptom,
        LocalDateTime reservationTime
) {
}
