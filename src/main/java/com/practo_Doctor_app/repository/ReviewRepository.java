package com.practo_Doctor_app.repository;

import com.practo_Doctor_app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    List<Review>findByDoctorId(long id);
}
