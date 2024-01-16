package com.practo_Doctor_app.service;

import com.practo_Doctor_app.entity.Doctor;
import com.practo_Doctor_app.entity.Patient;
import com.practo_Doctor_app.entity.Review;
import com.practo_Doctor_app.repository.DoctorRepository;
import com.practo_Doctor_app.repository.PatientRepository;
import com.practo_Doctor_app.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ReviewRepository reviewRepo;


    public Review createReview(Review review){
        Doctor doctor = doctorRepo.findById(review.getDoctorId()).get();
        Patient patient = patientRepo.findById(review.getPatientId()).get();

        Review savedReview =null;
        if(doctor!=null||patient!=null){
            reviewRepo.save(review);
        }
        return savedReview ;


    }

    public List<Review> getReviewByDoctorId(long doctorId){
        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
        return reviews;


    }
}
