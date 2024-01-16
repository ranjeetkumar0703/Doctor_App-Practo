//package com.practo_Doctor_app.entity;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//import java.time.LocalDateTime;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "appointments")
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private long patientId;
//    private  long doctorId;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable = false)
//    private Doctor doctor;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id", nullable = false)
//    private Patient patient;
//
//    @Column(nullable = false)
//    private LocalDateTime appointmentDateTime;
//
//}
