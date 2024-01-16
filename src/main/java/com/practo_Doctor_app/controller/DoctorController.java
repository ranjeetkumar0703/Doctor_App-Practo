package com.practo_Doctor_app.controller;

import com.practo_Doctor_app.entity.Doctor;
import com.practo_Doctor_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// DoctorController.java
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(addedDoctor, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specializations,
            @RequestParam(required = false) String qualification) {

        List<Doctor> doctors = doctorService.searchDoctors(name, specializations, qualification);

        if (doctors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(@RequestBody Doctor doctor) {
        List<Doctor> doctors = doctorService.searchDoctors(doctor.getName(), doctor.getSpecializations(),doctor.getQualification());

        if (doctors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}