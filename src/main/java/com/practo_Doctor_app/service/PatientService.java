package com.practo_Doctor_app.service;

import com.practo_Doctor_app.entity.Patient;
import com.practo_Doctor_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
        Patient savedPatient = patientRepository.save(patient);
        return patient;

    }
}
