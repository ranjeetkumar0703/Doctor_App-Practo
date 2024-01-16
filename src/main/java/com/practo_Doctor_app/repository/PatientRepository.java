package com.practo_Doctor_app.repository;


import com.practo_Doctor_app.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
