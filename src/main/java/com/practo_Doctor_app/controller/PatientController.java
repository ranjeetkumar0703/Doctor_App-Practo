package com.practo_Doctor_app.controller;

import com.practo_Doctor_app.entity.Patient;
import com.practo_Doctor_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<Patient>createPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);

    }
}
