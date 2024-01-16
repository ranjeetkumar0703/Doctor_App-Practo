package com.practo_Doctor_app.payload_Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private long doctorId;
    private long patientId;
    private String bookingTime;
}
