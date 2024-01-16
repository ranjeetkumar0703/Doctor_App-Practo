package com.practo_Doctor_app.repository;

import com.practo_Doctor_app.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {


//    @Query("SELECT d FROM Doctor d WHERE d.name Like%:search% OR d.specializations LIKE %:search% OR d.qualification LIKE %:search%")
//   List<Doctor> searchByNameOrSpecializationOrQualification(@Param("search") String search);

    List<Doctor> findByName(String name);
    List<Doctor> findBySpecializations(String specializations);
    List<Doctor> findByQualification(String qualification);
}
