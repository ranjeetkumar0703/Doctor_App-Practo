package com.practo_Doctor_app.service;

import com.practo_Doctor_app.entity.Doctor;
import com.practo_Doctor_app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }


    public List<Doctor> searchDoctors(String name, String specializations, String qualification) {
        if (name != null) {
            return doctorRepository.findByName(name);
        } else if (specializations != null) {
            return doctorRepository.findBySpecializations(specializations);
        } else if (qualification != null) {
            return doctorRepository.findByQualification(qualification);
        } else {
            // Return all doctors if no search criteria provided
            return doctorRepository.findAll();
        }
    }
}

