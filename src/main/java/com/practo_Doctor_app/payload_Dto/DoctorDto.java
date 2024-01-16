package com.practo_Doctor_app.payload_Dto;

import com.practo_Doctor_app.entity.Doctor;
import com.practo_Doctor_app.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Doctor doctor;
    private List<Review> reviews;
    private double ratingPercentage;
}
